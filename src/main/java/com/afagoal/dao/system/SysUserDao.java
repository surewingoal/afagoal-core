package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysUser;
import com.afagoal.entity.system.SysUser;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.surewingoal.constant.BaseStateConstant;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysUserDao extends BaseDao<SysUser,QSysUser> {
    public SysUserDao(){
        this.setQEntity(QSysUser.sysUser);
    }

    public SysUser getUserByName(String username){
        List<BooleanExpression> expressionList = new ArrayList();
        expressionList.add(this.getQEntity().userName.eq(username));
        expressionList.add(this.getQEntity().state.eq(BaseStateConstant.DEFAULT_STATE));
        List<SysUser> users = this.getEntities(expressionList,null);
        if(CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

}
