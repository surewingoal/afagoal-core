package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysUserRole;
import com.afagoal.entity.system.SysUserRole;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysUserRoleDao extends BaseDao<SysUserRole,QSysUserRole> {
    public SysUserRoleDao(){
        this.setQEntity(QSysUserRole.sysUserRole);
    }
}
