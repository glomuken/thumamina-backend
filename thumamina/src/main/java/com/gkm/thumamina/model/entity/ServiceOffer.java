package com.gkm.thumamina.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted is false")
public class ServiceOffer extends JpaBaseEntity {
    @ManyToOne
    User user;
    String name;
    String description;
    String picture;
    String rate;
    @OneToOne
    Category category;
}
