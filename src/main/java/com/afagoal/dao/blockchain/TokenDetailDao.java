package com.afagoal.dao.blockchain;

import com.afagoal.dao.BaseDao;
import com.afagoal.dto.base.ValueDateModel;
import com.afagoal.entity.blockchain.QTokenDetail;
import com.afagoal.entity.blockchain.TokenDetail;
import com.afagoal.utils.db.CustomAliasResultTransformer;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by BaoCai on 18/5/19.
 * Description:
 */
@Component
public class TokenDetailDao extends BaseDao<TokenDetail, QTokenDetail> {
    public TokenDetailDao() {
        this.setQEntity(QTokenDetail.tokenDetail);
    }

    public TokenDetail todayDetail(String id) {
        LocalDate now = LocalDate.now();
        List<BooleanExpression> list = new ArrayList();
        list.add(this.getQEntity().tokenId.eq(id));
        list.add(this.getQEntity().statisticTime.between(now.atStartOfDay(), now.atTime(23, 59, 59)));
        return this.getEntity(list);
    }

    public List<TokenDetail> todayDetails(Pageable pageable) {
        LocalDateTime now = LocalDateTime.now();
        List<BooleanExpression> list = new ArrayList();
        list.add(this.getQEntity().statisticTime.between(now.plusDays(-1), now));
        return this.getEntities(list, pageable);
    }

    public List<ValueDateModel> valueDateModels(int size, String tokenId) {
        String sql = "select " +
                "usd as value, " +
                "statistic_time as statisticTime " +
                "from bc_token_detail " +
                "where state <> 99 " +
                "and bc_token_id = ? " +
                "order by statistic_time desc " +
                "limit ? ;";
        Session session = (Session) this.getEntityManager().getDelegate();
        org.hibernate.Query query = session.createSQLQuery(sql)
                .setResultTransformer(new CustomAliasResultTransformer(ValueDateModel.class));
        query.setString(0,tokenId);
        query.setInteger(1,size);
        return query.list();
    }
}
