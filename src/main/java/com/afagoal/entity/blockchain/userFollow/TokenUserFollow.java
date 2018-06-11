package com.afagoal.entity.blockchain.userFollow;

import com.afagoal.entity.UuidEntity;
import com.afagoal.entity.system.SysDept;
import com.afagoal.entity.system.SysUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "bc_token_id")
    private String tokenId;

    @Column(name = "bc_token_code")
    private String tokenCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private SysUser user;

}
