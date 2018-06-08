package com.afagoal.dao.blockchain;

import com.afagoal.constant.BaseConstant;
import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.QTokenTopPercentage;
import com.afagoal.entity.blockchain.TokenTopPercentage;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by BaoCai on 18/6/4.
 * Description:
 */
@Repository
public class TokenTopPercentageDao extends BaseDao<TokenTopPercentage, QTokenTopPercentage> {
    public TokenTopPercentageDao() {
        this.setQEntity(QTokenTopPercentage.tokenTopPercentage);
    }

    public TokenTopPercentage getById(String id) {
        List<BooleanExpression> expressions = new ArrayList();
        expressions.add(this.getQEntity().state.ne(BaseConstant.DELETE_STATE));
        expressions.add(this.getQEntity().id.eq(id));
        return this.getEntity(expressions);
    }
}
