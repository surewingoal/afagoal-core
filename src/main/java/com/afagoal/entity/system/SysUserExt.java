package com.afagoal.entity.system;

import com.afagoal.entity.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/6/28.
 * Description:
 */
@Entity
@Getter
@Setter
@Table(name = "sys_user_ext")
public class SysUserExt extends IdEntity {

    @Column(name = "user_id")
    private Integer userId;

    private String wechatNickName;

    private String wechatAvatarUrl;

    private Byte wechatGender;

    private String wechatCity;

    private String wechatProvince;

    private String wechatLanguage;

    private String wechatCountry;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private SysUser user;

}
