package com.afagoal.entity.behavior;

import com.afagoal.entity.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/4/15.
 * Description:
 */
@Entity
@Table(name = "sa_user_behavior_log")
@Getter
@Setter
public class UserBehaviorLog extends IdEntity {

    private String method;

    private Long usingTime;

    @Column(name = "user_id")
    private Integer userId;

    private String userName;

    private String operation;

    private String operateIp;

}
