package com.gkm.thumamina.repository;

import com.gkm.thumamina.model.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
