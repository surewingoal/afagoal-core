package com.afagoal.entity.system;

import com.afagoal.entity.UuidEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Entity
@Table(name = "sys_function")
@Getter
@Setter
public class SysFunction extends UuidEntity {

    private String functionName;

    private String functionUrl;

    private String functionParentId;

    private String introduce;

    private Integer level;
}
