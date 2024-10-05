package com.gkm.thumamina.repository;

import com.gkm.thumamina.model.entity.ServiceOffer;

import com.gkm.thumamina.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceOfferRepository extends JpaRepository<ServiceOffer,Long> {
    List<ServiceOffer> findAllByUser(User user);
}
