package com.gkm.thumamina.model.entity;

import com.gkm.thumamina.enums.Type;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.json.JSONObject;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted is false")
public class User extends JpaEntityBase  {
    String name;
    String surname;
    String email;
    String number;
    String location;
    BigDecimal rating;
    Type type;
}
