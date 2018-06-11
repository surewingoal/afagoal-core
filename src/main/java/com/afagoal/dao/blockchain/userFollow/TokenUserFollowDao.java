package com.afagoal.dao.blockchain.userFollow;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.userFollow.QTokenUserFollow;
import com.afagoal.entity.blockchain.userFollow.TokenUserFollow;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by BaoCai on 18/6/10.
 * Description:
 */
@Repository
public class TokenUserFollowDao extends BaseDao<TokenUserFollow, QTokenUserFollow> {

    public static final byte FOLLOW_STATE = 0;
    public static final byte UN_FOLLOW_STATE = 1;

    public TokenUserFollowDao() {
        this.setQEntity(QTokenUserFollow.tokenUserFollow);
    }

    public TokenUserFollow findByTokenIdAndUser(String tokenId, Integer userId) {
        List<BooleanExpression> booleanExpressions = new ArrayList();
        booleanExpressions.add(this.getQEntity().state.eq(FOLLOW_STATE));
        booleanExpressions.add(this.getQEntity().userId.eq(userId));
        booleanExpressions.add(this.getQEntity().tokenId.eq(tokenId));
        return this.getEntity(booleanExpressions);
    }

    public List<TokenUserFollow> findByTokenId(String tokenId) {
        List<BooleanExpression> booleanExpressions = new ArrayList();
        booleanExpressions.add(this.getQEntity().state.eq(FOLLOW_STATE));
        booleanExpressions.add(this.getQEntity().tokenId.eq(tokenId));

        JPAQuery<TokenUserFollow> query = new JPAQuery<>(this.getEntityManager());

        query.select(this.getQEntity())
                .from(this.getQEntity())
                .leftJoin(this.getQEntity().user).fetchJoin()
                .where(booleanExpressions.toArray(new BooleanExpression[booleanExpressions.size()]));

        return query.fetch();
    }
}
