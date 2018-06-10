package com.afagoal.dao.blockchain.valueWatcher;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.valueWatch.QValueWatcher;
import com.afagoal.entity.blockchain.valueWatch.ValueWatcher;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 18/6/10.
 * Description:
 */
@Repository
public class ValueWatcherDao extends BaseDao<ValueWatcher, QValueWatcher> {
    public ValueWatcherDao(){
        this.setQEntity(QValueWatcher.valueWatcher);
    }
}
