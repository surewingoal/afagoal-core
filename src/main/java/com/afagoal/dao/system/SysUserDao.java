package com.afagoal.dao.system;

import com.afagoal.constant.BaseConstant;
import com.afagoal.dao.BaseDao;
import com.afagoal.entity.system.QSysUser;
import com.afagoal.entity.system.SysUser;
import com.querydsl.core.types.dsl.BooleanExpression;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Repository
public class SysUserDao extends BaseDao<SysUser, QSysUser> {

    public SysUserDao() {
        this.setQEntity(QSysUser.sysUser);
    }

    public SysUser getUserByName(String username) {
        List<BooleanExpression> expressionList = new ArrayList();
        expressionList.add(this.getQEntity().userName.eq(username));
        expressionList.add(this.getQEntity().state.eq(BaseConstant.DEFAULT_STATE));
        List<SysUser> users = this.getEntities(expressionList, null);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }

    public SysUser getUserByKey(String key) {
        List<BooleanExpression> expressionList = new ArrayList();
        expressionList.add(this.getQEntity().userName.eq(key)
                .or(this.getQEntity().mobile.eq(key)));
        expressionList.add(this.getQEntity().state.eq(BaseConstant.DEFAULT_STATE));
        List<SysUser> users = this.getEntities(expressionList, null);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }

    public SysUser getById(Integer id) {
        List<BooleanExpression> expressionList = new ArrayList();
        expressionList.add(this.getQEntity().id.eq(id));
        expressionList.add(this.getQEntity().state.eq(BaseConstant.DEFAULT_STATE));
        return this.getEntity(expressionList);
    }

    public int delete(List<Integer> idList) {
        String sql = "update sys_user set state = 99 where id in (?1)";
        Query query = this.getEntityManager().createNativeQuery(sql);
        query.setParameter(1, idList);
        return query.executeUpdate();
    }
}
