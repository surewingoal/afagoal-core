package com.afagoal.dao.blockchain;

import com.afagoal.constant.BaseConstant;
import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.QTokenExt;
import com.afagoal.entity.blockchain.TokenExt;
import com.querydsl.core.types.dsl.BooleanExpression;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BaoCai on 18/5/28.
 * Description:
 */
@Repository
public class TokenExtDao extends BaseDao<TokenExt, QTokenExt> {

    public TokenExtDao() {
        this.setQEntity(QTokenExt.tokenExt);
    }

    public List<TokenExt> getByTokenIds(List<String> tokenIds) {
        List<BooleanExpression> list = new ArrayList();
        list.add(this.getQEntity().state.ne(BaseConstant.DELETE_STATE));
        list.add(this.getQEntity().tokenId.in(tokenIds));
        return this.getEntities(list, null);
    }

}
