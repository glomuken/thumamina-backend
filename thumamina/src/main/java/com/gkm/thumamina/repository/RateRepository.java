package com.gkm.thumamina.repository;

import com.gkm.thumamina.model.entity.Rate;
import com.gkm.thumamina.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;

import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate,Long> {
    Optional<Rate> findByUser(User user);
}
