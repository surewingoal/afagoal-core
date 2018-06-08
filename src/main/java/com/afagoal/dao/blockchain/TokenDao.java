package com.afagoal.dao.blockchain;

import com.afagoal.dao.BaseDao;
import com.afagoal.dto.blockchain.TokenSimpleDto;
import com.afagoal.entity.blockchain.QToken;
import com.afagoal.entity.blockchain.Token;
import com.afagoal.utils.db.CustomAliasResultTransformer;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
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
        String sql = "select t.id as id,t.token_name as tokenName from bc_token t " +
                "left join bc_token_ext e " +
                "on t.id = e.bc_token_id " +
                "order by e.transfers desc";
        Session session = (Session) this.getEntityManager().getDelegate();
        org.hibernate.Query query = session.createSQLQuery(sql)
                .setResultTransformer(new CustomAliasResultTransformer(TokenSimpleDto.class));
        return query.list();
    }
}
