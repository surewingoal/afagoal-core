package com.afagoal.dao.blockchain;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.QTokenDetail;
import com.afagoal.entity.blockchain.TokenDetail;

import org.springframework.stereotype.Component;

/**
 * Created by BaoCai on 18/5/19.
 * Description:
 */
@Component
public class TokenDetailDao extends BaseDao<TokenDetail,QTokenDetail> {
    public TokenDetailDao(){
        this.setQEntity(QTokenDetail.tokenDetail);
    }
}
