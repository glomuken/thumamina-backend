package com.gkm.thumamina.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@Where(clause = "is_deleted is false")
public class Chat extends JpaBaseEntity{
    String userId;
    String message;
    LocalDate localDate;
}
