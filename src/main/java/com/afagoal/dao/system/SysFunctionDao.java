package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysFunction;
import com.afagoal.entity.system.SysFunction;
import com.querydsl.core.types.dsl.BooleanExpression;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysFunctionDao extends BaseDao<SysFunction, QSysFunction> {
    public SysFunctionDao() {
        this.setQEntity(QSysFunction.sysFunction);
    }

    public int delete(String[] idArray) {
        List<Integer> ids = Arrays.stream(idArray)
                .map(id -> Integer.valueOf(id))
                .collect(Collectors.toList());
        String sql = "delete from sys_function where id in (?1)";
        Query query = this.getEntityManager().createNativeQuery(sql);
        query.setParameter(1,ids);
        return query.executeUpdate();
    }

    public SysFunction getById(Integer id){
        List<BooleanExpression> booleanExpressions = new ArrayList();
        booleanExpressions.add(this.getQEntity().id.eq(id));
        SysFunction function = this.getEntity(booleanExpressions);
        return function;
    }

    public List<SysFunction> userFunction(Integer userId) {
        String sql = "select f.* from sys_function f \n" +
                "left join sys_role_function rf \n" +
                "on rf.function_id = f.id\n" +
                "left join sys_role r\n" +
                "on rf.role_id = r.id\n" +
                "left join sys_user_role ur \n" +
                "on r.id = ur.role_id\n" +
                "left join sys_user u\n" +
                "on u.id = ur.user_id\n" +
                "where u.id = (?1)";
        Query query = this.getEntityManager().createNativeQuery(sql,SysFunction.class);
        query.setParameter(1,userId);
        return query.getResultList();
    }
}
