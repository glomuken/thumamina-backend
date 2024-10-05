package com.gkm.thumamina.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted is false")
public class Rate extends JpaEntityBase{
   BigDecimal rateTotal;
   BigDecimal votes;
}
