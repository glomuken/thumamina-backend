package com.gkm.thumamina.model.entity;

import com.gkm.thumamina.enums.Type;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;


import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted is false")
public class User extends JpaBaseEntity  {
    String name;
    String surname;
    String email;
    String number;
    String location;
    BigDecimal rating;
    Type type;
}
