package com.afagoal.dao.blockchain;

import com.afagoal.constant.BaseStateConstant;
import com.afagoal.dao.BaseDao;
import com.afagoal.entity.blockchain.QTokenLink;
import com.afagoal.entity.blockchain.TokenLink;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by BaoCai on 18/5/20.
 * Description:
 */
@Component
public class TokenLinkDao extends BaseDao<TokenLink , QTokenLink> {
    public TokenLinkDao(){
        this.setQEntity(QTokenLink.tokenLink);
    }

    public Collection<TokenLink> getTokenLinks(String tokenId){
        List<BooleanExpression> list = new ArrayList();
        list.add(this.getQEntity().state.ne(BaseStateConstant.DELETE_STATE));
        list.add(this.getQEntity().tokenId.eq(tokenId));
        return this.getEntities(list,null);
    }
}
