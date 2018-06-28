package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysUserExt;
import com.afagoal.entity.system.SysUserExt;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 18/6/28.
 * Description:
 */
@Repository
public class SysUserExtDao extends BaseDao<SysUserExt, QSysUserExt> {

    public SysUserExtDao() {
        this.setQEntity(QSysUserExt.sysUserExt);
    }

}
