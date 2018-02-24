package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysRoleFunction;
import com.afagoal.entity.system.SysRoleFunction;
import java.util.List;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysRoleFunctionDao extends BaseDao<SysRoleFunction,QSysRoleFunction> {
    public SysRoleFunctionDao(){
        this.setQEntity(QSysRoleFunction.sysRoleFunction);
    }

    public int delete(Integer roleId, List<Integer> functions) {
        String sql = "delete from sys_role_function where role_id = ?1 and function_id in (?2)";
        Query query = this.getEntityManager().createNativeQuery(sql);
        query.setParameter(1,roleId);
        query.setParameter(2,functions);
        return query.executeUpdate();
    }

}
