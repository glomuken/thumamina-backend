package com.gkm.thumamina.model.dto;

import com.gkm.thumamina.model.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceOfferDto extends BaseDto{
    String name;
    String description;
    String picture;
    Long categoryId;
    String rate;

}
