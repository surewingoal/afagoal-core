package com.afagoal.dao.behavior;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.behavior.QUserBehaviorLog;
import com.afagoal.entity.behavior.UserBehaviorLog;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by BaoCai on 18/4/15.
 * Description:
 */
@Component
public class UserBehaviorLogDao extends BaseDao<UserBehaviorLog,QUserBehaviorLog> {

    public UserBehaviorLogDao(){
        this.setQEntity(QUserBehaviorLog.userBehaviorLog);
    }

    @Transactional
    public void add(UserBehaviorLog log){
        this.save(log);
    }

    @Transactional
    public void add(Collection<UserBehaviorLog> logs){
        this.save(logs);
    }
}
