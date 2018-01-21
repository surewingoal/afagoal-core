package com.afagoal.dto.system;

import com.afagoal.dto.BaseDto;
import com.afagoal.entity.system.SysFunction;

import org.springframework.beans.BeanUtils;

import lombok.Data;

/**
 * Created by BaoCai on 18/1/6.
 * Description:
 */
@Data
public class FunctionDto extends BaseDto{

    private String functionName;

    private String functionUrl;

    private String parentName;

    private String introduce;

    private String functionParentId;

    public static FunctionDto instance(SysFunction function, String parentName){
        if(null == function){
            return null;
        }
        FunctionDto dto = new FunctionDto();
        BeanUtils.copyProperties(function,dto);
        dto.setParentName(parentName);
        return dto;
    }
}
