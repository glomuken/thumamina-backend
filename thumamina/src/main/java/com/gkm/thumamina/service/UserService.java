package com.gkm.thumamina.service;

import com.gkm.thumamina.enums.Type;
import com.gkm.thumamina.exception.RecordNotFoundException;
import com.gkm.thumamina.model.dto.UserDto;
import com.gkm.thumamina.model.entity.Rate;
import com.gkm.thumamina.model.entity.User;
import com.gkm.thumamina.repository.RateRepository;
import com.gkm.thumamina.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RateRepository rateRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new RecordNotFoundException("User not found"));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll(); //area string
    }

    public UserDto createUser(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(user.getName());
        user.setRating(BigDecimal.valueOf(0));
        user.setSurname(userDto.getSurname());
        user.setNumber(userDto.getNumber());
        if (userDto.getType().equalsIgnoreCase("ServiceProvider")){
            user.setType(Type.ServiceProvider);
        } else if (userDto.getType().equalsIgnoreCase("Consumer")) {
            user.setType(Type.Consumer);
        };
        userRepository.save(user);
        return userDto;
    }

    public BigDecimal getRating(Long id){
        User user = userRepository.findById(id).orElseThrow(()->new RecordNotFoundException("User not found"));
        Rate rate = rateRepository.findByUser(user).orElseThrow(()->new RecordNotFoundException("User not rated yet"));
        BigDecimal rating = rate.getRateTotal().divide(rate.getVotes(), RoundingMode.CEILING);
        user.setRating(rating);
        userRepository.save(user);
        return rating;
    }
}
