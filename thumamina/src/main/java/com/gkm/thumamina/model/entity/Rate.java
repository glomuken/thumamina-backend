package com.gkm.thumamina.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted is false")
public class Rate extends JpaBaseEntity{
   @OneToOne
   User user;
   BigDecimal rateTotal = BigDecimal.valueOf(0);
   BigDecimal votes = BigDecimal.valueOf(0);
}
