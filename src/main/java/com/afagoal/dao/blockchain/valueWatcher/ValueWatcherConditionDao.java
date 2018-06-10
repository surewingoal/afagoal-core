package com.afagoal.dao.blockchain.valueWatcher;

import com.afagoal.constant.BaseConstant;
import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.valueWatch.QValueWatcherCondition;
import com.afagoal.entity.blockchain.valueWatch.ValueWatcherCondition;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BaoCai on 18/6/10.
 * Description:
 */
@Repository
public class ValueWatcherConditionDao extends BaseDao<ValueWatcherCondition, QValueWatcherCondition> {
    public ValueWatcherConditionDao() {
        this.setQEntity(QValueWatcherCondition.valueWatcherCondition);
    }

    public List<ValueWatcherCondition> getByWatcherType(Byte watcherType) {
        List<BooleanExpression> booleanExpressions = new ArrayList();
        booleanExpressions.add(this.getQEntity().state.ne(BaseConstant.DELETE_STATE));
        booleanExpressions.add(this.getQEntity().watchType.eq(watcherType));

        List<OrderSpecifier> orders = new ArrayList();
        orders.add(this.getQEntity().watchDays.asc());
        return this.getEntities(booleanExpressions, orders, null);
    }
}
