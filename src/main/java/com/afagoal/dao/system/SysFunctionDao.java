package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysFunction;
import com.afagoal.entity.system.SysFunction;
import com.querydsl.core.types.dsl.BooleanExpression;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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

    public SysFunction getFunctionByFunctionUrl(String functionUrl){
        List<BooleanExpression> expressionList = new ArrayList();
        expressionList.add(this.getQEntity().functionUrl.eq(functionUrl));
        List<SysFunction> functions = this.getEntities(expressionList,null);
        if(CollectionUtils.isEmpty(functions)){
            return null;
        }
        return functions.get(0);
    }

    public int delete(String[] idArray) {
        String sql = "update sys_function set state = 99 where id in (?1)";
        Query query = this.getEntityManager().createNativeQuery(sql);
        query.setParameter(1,idArray);
        return query.executeUpdate();
    }
}