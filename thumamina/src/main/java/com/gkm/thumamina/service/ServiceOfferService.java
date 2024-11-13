package com.gkm.thumamina.service;

import com.gkm.thumamina.exception.RecordNotFoundException;
import com.gkm.thumamina.model.dto.ServiceOfferDto;
import com.gkm.thumamina.model.entity.ServiceOffer;
import com.gkm.thumamina.model.entity.User;
import com.gkm.thumamina.repository.CategoryRepository;
import com.gkm.thumamina.repository.ServiceOfferRepository;
import com.gkm.thumamina.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOfferService {

    private final ServiceOfferRepository serviceOfferRepository;
    private  final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    public List<ServiceOffer> getAllUserServices(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new RecordNotFoundException("User not found"));
        return serviceOfferRepository.findAllByUser(user);
    }

    public List<ServiceOffer> getAllServices(){
        return serviceOfferRepository.findAll();
    }
    
    public ServiceOffer getServiceById(Long id){
        return serviceOfferRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Service does not exist"));
    }
    
    public ServiceOfferDto setServiceDto(Long userId,ServiceOfferDto serviceOfferDto){
        ServiceOffer serviceOffer = new ServiceOffer();
        serviceOffer.setName(serviceOfferDto.getName());
        serviceOffer.setCategory(categoryRepository.findById(serviceOfferDto.getCategoryId()).orElseThrow(()->new RecordNotFoundException("Service does not exist")));
        serviceOffer.setDescription(serviceOfferDto.getDescription());
        serviceOffer.setPicture(serviceOfferDto.getPicture());
        serviceOffer.setRate(serviceOfferDto.getRate());
        serviceOfferRepository.save(serviceOffer);
        return serviceOfferDto;
    }


}
