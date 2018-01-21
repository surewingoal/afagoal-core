package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysRoleFunction;
import com.afagoal.entity.system.SysRoleFunction;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysRoleFunctionDao extends BaseDao<SysRoleFunction,QSysRoleFunction> {
    public SysRoleFunctionDao(){
        this.setQEntity(QSysRoleFunction.sysRoleFunction);
    }
}
