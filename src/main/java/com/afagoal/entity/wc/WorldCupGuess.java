package com.afagoal.entity.wc;

import com.afagoal.entity.UuidEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/6/3.
 * Description:
 */
@Entity
@Table(name = "wc_world_guess")
@Getter
@Setter
public class WorldCupGuess extends UuidEntity {

    private String wechatNickName;

    private String champion;

    private String avatarUrl;

    private Byte gender;

    private String city;

    private String province;

    private String language;

    private String country;

    private String mobile;

}
