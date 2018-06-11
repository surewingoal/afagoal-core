package com.afagoal.entity.blockchain.userFollow;

import com.afagoal.entity.UuidEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/6/10.
 * Description:
 */
@Table(name = "bc_token_user_follow")
@Entity
@Getter
@Setter
public class TokenUserFollow extends UuidEntity {

    private Integer userId;

    @Column(name = "bc_token_id")
    private String tokenId;

    @Column(name = "bc_token_code")
    private String tokenCode;

}
