package com.gkm.thumamina.model.dto;

import com.gkm.thumamina.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends BaseDto{
    String name;
    String surname;
    String email;
    String number;
    String type;

}
