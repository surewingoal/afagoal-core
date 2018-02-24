package com.afagoal.dao.system;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysDept;
import com.afagoal.entity.system.SysDept;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import javax.persistence.Query;

/**
 * Created by BaoCai on 18/2/24.
 * Description:
 */
@Component
public class SysDeptDao extends BaseDao<SysDept,QSysDept> {

    public SysDeptDao(){
        this.setQEntity(QSysDept.sysDept);
    }

    public SysDept getById(Integer id) {
        if(null == id){
            return null;
        }
        List<BooleanExpression> booleanExpressions = new ArrayList();
        booleanExpressions.add(this.getQEntity().state.ne((byte) 99));
        booleanExpressions.add(this.getQEntity().id.eq(id));
        return this.getEntity(booleanExpressions);
    }

    public int delete(String[] idArr) {
        List<Integer> ids = Arrays.stream(idArr)
                .map(id -> Integer.valueOf(id))
                .collect(Collectors.toList());
        String sql = "update sys_dept set state = 99 where id in (?1)";
        Query query = this.getEntityManager().createNativeQuery(sql);
        query.setParameter(1,ids);
        return query.executeUpdate();
    }
}
