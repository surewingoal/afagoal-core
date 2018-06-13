package com.afagoal.dao.blockchain;

import com.afagoal.constant.BaseConstant;
import com.afagoal.dao.BaseDao;
import com.afagoal.dto.base.ValueDateModel;
import com.afagoal.entity.blockchain.QTokenTopPercentage;
import com.afagoal.entity.blockchain.TokenTopPercentage;
import com.afagoal.utils.db.CustomAliasResultTransformer;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by BaoCai on 18/6/4.
 * Description:
 */
@Repository
public class TokenTopPercentageDao extends BaseDao<TokenTopPercentage, QTokenTopPercentage> {
    public TokenTopPercentageDao() {
        this.setQEntity(QTokenTopPercentage.tokenTopPercentage);
    }

    public TokenTopPercentage getById(String id) {
        List<BooleanExpression> expressions = new ArrayList();
        expressions.add(this.getQEntity().state.ne(BaseConstant.DELETE_STATE));
        expressions.add(this.getQEntity().id.eq(id));
        return this.getEntity(expressions);
    }

    public List<ValueDateModel> valueDateModels(int size, String tokenId, byte topType) {
        String sql = "select " +
                "percentage as value, " +
                "statistic_time as statisticTime " +
                "from bc_token_top_percentage " +
                "where state <> 99 " +
                "and bc_token_id = ? " +
                "and top_type = ? " +
                "order by statistic_time desc " +
                "limit ? ;";
        Session session = (Session) this.getEntityManager().getDelegate();
        org.hibernate.Query query = session.createSQLQuery(sql)
                .setResultTransformer(new CustomAliasResultTransformer(ValueDateModel.class));
        query.setParameter(0, tokenId);
        query.setParameter(1, topType);
        query.setParameter(2, size);
        return query.list();
    }
}
