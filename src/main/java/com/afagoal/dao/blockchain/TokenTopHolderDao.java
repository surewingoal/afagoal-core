package com.afagoal.dao.blockchain;

import com.afagoal.constant.BaseConstant;
import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.QTokenTopHolder;
import com.afagoal.entity.blockchain.TokenTopHolder;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by BaoCai on 18/5/19.
 * Description:
 */
@Component
public class TokenTopHolderDao extends BaseDao<TokenTopHolder,QTokenTopHolder> {
    public TokenTopHolderDao(){
        this.setQEntity(QTokenTopHolder.tokenTopHolder);
    }

    public TokenTopHolder getById(String id) {
        List<BooleanExpression> list = new ArrayList();
        list.add(this.getQEntity().state.ne(BaseConstant.DELETE_STATE));
        list.add(this.getQEntity().id.eq(id));
        return this.getEntity(list);
    }
}
