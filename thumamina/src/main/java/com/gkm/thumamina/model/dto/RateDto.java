package com.gkm.thumamina.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RateDto extends BaseDto {
    BigDecimal rate;
}
