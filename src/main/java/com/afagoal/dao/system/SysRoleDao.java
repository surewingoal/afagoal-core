package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysRole;
import com.afagoal.entity.system.SysRole;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysRoleDao extends BaseDao<SysRole,QSysRole> {
    public SysRoleDao(){
        this.setQEntity(QSysRole.sysRole);
    }
}
