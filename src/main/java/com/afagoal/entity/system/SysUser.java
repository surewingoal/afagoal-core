package com.afagoal.entity.system;

import com.afagoal.entity.IdEntity;
import com.afagoal.entity.UuidEntity;

import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 17/10/25.
 * Description:
 */
@Entity
@Table(name = "sys_user")
@Getter
@Setter
public class SysUser extends IdEntity{
    private String userName;

    private String nickName;

    private String realName;

    private String password;

    private String loginIp;

    private int loginTimes;

    private String email;

    private String mobile;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "user_type")
    private Integer userType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id",insertable = false,updatable = false)
    private SysDept dept;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "sys_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<SysRole> roles;
}
