package com.afagoal.dao.blockchain;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.QTokenTopHolder;
import com.afagoal.entity.blockchain.TokenTopHolder;

import org.springframework.stereotype.Component;

/**
 * Created by BaoCai on 18/5/19.
 * Description:
 */
@Component
public class TokenTopHolderDao extends BaseDao<TokenTopHolder,QTokenTopHolder> {
    public TokenTopHolderDao(){
        this.setQEntity(QTokenTopHolder.tokenTopHolder);
    }
}
