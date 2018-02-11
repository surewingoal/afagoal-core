package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysRole;
import com.afagoal.entity.system.SysRole;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysRoleDao extends BaseDao<SysRole,QSysRole> {
    public SysRoleDao(){
        this.setQEntity(QSysRole.sysRole);
    }

    public SysRole getById(Integer id) {
        List<BooleanExpression> list = new ArrayList();
        list.add(this.getQEntity().id.eq(id));
        return this.getEntity(list);
    }

    public int delete(Set<Integer> idSet) {
        String sql = "update sys_role set state = 99 where id in (?1) ";
        Query query = this.getEntityManager().createNativeQuery(sql);
        query.setParameter(1,idSet);
        return query.executeUpdate();
    }
}
