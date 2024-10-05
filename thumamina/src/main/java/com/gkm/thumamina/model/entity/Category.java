package com.gkm.thumamina.model.entity;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted is false")
public class Category extends JpaEntityBase{
    String name;
    String description;
}
