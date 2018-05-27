package com.afagoal.dao.blockchain;

import com.afagoal.dao.BaseDao;
import com.afagoal.dto.blockchain.TokenSimpleDto;
import com.afagoal.entity.blockchain.QToken;
import com.afagoal.entity.blockchain.Token;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.persistence.Query;

/**
 * Created by BaoCai on 18/5/19.
 * Description:
 */
@Component
public class TokenDao extends BaseDao<Token,QToken> {

    public TokenDao(){
        this.setQEntity(QToken.token);
    }

    public List<Token> getTokens(List<BooleanExpression> booleanExpressions,
                                 List<OrderSpecifier> orders,
                                 Pageable pageable){
        booleanExpressions = this.rectifyExpressions(booleanExpressions);

        JPAQuery<Token> query = new JPAQuery<>(this.getEntityManager());

        query.select(QEntity)
                .from(QEntity)
                .where(booleanExpressions.toArray(new BooleanExpression[booleanExpressions.size()]));

        if (!CollectionUtils.isEmpty(orders)) {
            query.orderBy(orders.toArray(new OrderSpecifier[orders.size()]));
        }

        if (pageable != null) {
            query.offset(pageable.getOffset()).limit(pageable.getPageSize());
        }
        return query.fetch();
    }

    public List<TokenSimpleDto> simpleTokens() {
        String sql = "select id,token_code from bc_token where state <> 99 ; ";
        Query query = this.getEntityManager().createNativeQuery(sql);
        List<Object[]> tokens = query.getResultList();
        List<TokenSimpleDto> dtos = tokens.stream()
                .map(strs -> TokenSimpleDto.instance((String)strs[0],(String)strs[1]))
                .collect(Collectors.toList());
        return dtos;
    }
}
