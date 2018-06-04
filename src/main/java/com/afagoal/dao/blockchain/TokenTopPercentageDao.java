package com.afagoal.dao.blockchain;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.QTokenTopPercentage;
import com.afagoal.entity.blockchain.TokenTopPercentage;

import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 18/6/4.
 * Description:
 */
@Repository
public class TokenTopPercentageDao extends BaseDao<TokenTopPercentage,QTokenTopPercentage> {
    public TokenTopPercentageDao(){
        this.setQEntity(QTokenTopPercentage.tokenTopPercentage);
    }
}
