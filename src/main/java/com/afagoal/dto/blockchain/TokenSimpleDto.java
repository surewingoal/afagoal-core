package com.afagoal.dto.blockchain;

import org.springframework.util.Assert;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BaoCai on 18/5/27.
 * Description:
 */
@Getter
@Setter
public class TokenSimpleDto {

    private String id;
    private String tokenName;

    public static TokenSimpleDto instance(String id,String tokenName) {
        Assert.notNull(id,"请传入token_id");
        Assert.notNull(tokenName,"请传入token_name");
        TokenSimpleDto dto = new TokenSimpleDto();
        dto.setId(id);
        dto.setTokenName(tokenName);
        return dto;
    }

}
