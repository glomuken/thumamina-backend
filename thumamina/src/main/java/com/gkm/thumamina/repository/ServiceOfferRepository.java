package com.gkm.thumamina.repository;

import org.hibernate.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOfferRepository extends JpaRepository<Service,Long> {
}
