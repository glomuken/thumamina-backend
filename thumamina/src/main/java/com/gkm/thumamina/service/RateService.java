package com.gkm.thumamina.service;

import com.gkm.thumamina.exception.RecordNotFoundException;
import com.gkm.thumamina.model.dto.RateDto;
import com.gkm.thumamina.model.entity.Rate;
import com.gkm.thumamina.model.entity.User;
import com.gkm.thumamina.repository.RateRepository;
import com.gkm.thumamina.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RateRepository rateRepository;
    private  final UserRepository userRepository;

    public RateDto updateRate(Long id, RateDto rateDto){
        User user = userRepository.findById(id).orElseThrow(()->new RecordNotFoundException("User not found"));
        Rate rate = rateRepository.findByUser(user).orElseThrow(()->new RecordNotFoundException("User not rated yet"));
        BigDecimal oldRate = rate.getRateTotal();
        rate.setRateTotal(oldRate.add(rateDto.getRate()));
        rateRepository.save(rate);
        rateDto.setRate(rate.getRateTotal());
        return rateDto;
    }
}
