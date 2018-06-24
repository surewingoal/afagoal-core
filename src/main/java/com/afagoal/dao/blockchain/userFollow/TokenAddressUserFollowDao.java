package com.afagoal.dao.blockchain.userFollow;

import com.afagoal.dao.BaseDao;
import com.afagoal.dto.blockchain.TokenTopHolderSimpleDto;
import com.afagoal.entity.blockchain.userFollow.QTokenAddressUserFollow;
import com.afagoal.entity.blockchain.userFollow.TokenAddressUserFollow;
import com.afagoal.utils.db.CustomAliasResultTransformer;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by BaoCai on 18/6/13.
 * Description:
 */
@Repository
public class TokenAddressUserFollowDao extends BaseDao<TokenAddressUserFollow, QTokenAddressUserFollow> {

    public TokenAddressUserFollowDao() {
        this.setQEntity(QTokenAddressUserFollow.tokenAddressUserFollow);
    }

    public List<TokenTopHolderSimpleDto> followedAddress() {
        String sql = "select distinct address as address,bc_token_id as id,bc_token_code as tokenName from bc_token_address_user_follow ; ";
        Session session = (Session) this.getEntityManager().getDelegate();
        org.hibernate.Query query = session.createSQLQuery(sql)
                .setResultTransformer(new CustomAliasResultTransformer(TokenTopHolderSimpleDto.class));
        return query.list();
    }
}
