package com.gkm.thumamina.repository;

import com.gkm.thumamina.model.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;

public interface RateRepository extends JpaRepository<Rate,Long> {
}
