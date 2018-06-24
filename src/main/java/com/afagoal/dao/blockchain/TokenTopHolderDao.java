package com.afagoal.dao.blockchain;

import com.afagoal.constant.BaseConstant;
import com.afagoal.dao.BaseDao;
import com.afagoal.dto.base.ValueDateModel;
import com.afagoal.entity.blockchain.QTokenTopHolder;
import com.afagoal.entity.blockchain.TokenTopHolder;
import com.afagoal.utils.db.CustomAliasResultTransformer;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by BaoCai on 18/5/19.
 * Description:
 */
@Component
public class TokenTopHolderDao extends BaseDao<TokenTopHolder, QTokenTopHolder> {
    public TokenTopHolderDao() {
        this.setQEntity(QTokenTopHolder.tokenTopHolder);
    }

    public TokenTopHolder getById(String id) {
        List<BooleanExpression> list = new ArrayList();
        list.add(this.getQEntity().state.ne(BaseConstant.DELETE_STATE));
        list.add(this.getQEntity().id.eq(id));
        return this.getEntity(list);
    }

    public List<ValueDateModel> valueDateModels(int watcherSize, String tokenId, String address) {
        String sql = "select " +
                "percentage as value, " +
                "statistic_time as statisticTime " +
                "from bc_token_top_holder " +
                "where state <> 99 " +
                "and bc_token_id = ? " +
                "and address = ? " +
                "order by statistic_time desc " +
                "limit ? ;";
        Session session = (Session) this.getEntityManager().getDelegate();
        org.hibernate.Query query = session.createSQLQuery(sql)
                .setResultTransformer(new CustomAliasResultTransformer(ValueDateModel.class));
        query.setParameter(0, tokenId);
        query.setParameter(1, address);
        query.setParameter(2, watcherSize);
        return query.list();
    }
}
