package com.afagoal.entity.system;

import com.afagoal.entity.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/2/24.
 * Description:
 */
@Entity
@Getter
@Setter
@Table(name = "sys_dept")
public class SysDept extends IdEntity {

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "introduce")
    private String introduce;
}
