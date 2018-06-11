package com.afagoal.dao.blockchain.valueWatcher;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.valueWatch.QValueWatcher;
import com.afagoal.entity.blockchain.valueWatch.ValueWatcher;
import com.querydsl.core.types.dsl.BooleanExpression;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BaoCai on 18/6/10.
 * Description:
 */
@Repository
public class ValueWatcherDao extends BaseDao<ValueWatcher, QValueWatcher> {
    public ValueWatcherDao(){
        this.setQEntity(QValueWatcher.valueWatcher);
    }

    public List<ValueWatcher> todayWatcher() {
        List<BooleanExpression> booleanExpressions = new ArrayList();
        booleanExpressions.add(this.getQEntity().today.eq(LocalDate.now()));
        return this.getEntities(booleanExpressions,null);
    }
}
