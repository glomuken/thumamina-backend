package com.gkm.thumamina.controller;

import com.gkm.thumamina.model.dto.ServiceOfferDto;
import com.gkm.thumamina.model.entity.ServiceOffer;
import com.gkm.thumamina.service.ServiceOfferService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-offer")
@RequiredArgsConstructor
public class ServiceOfferController {

    private final ServiceOfferService serviceOfferService;

    @GetMapping("/all")
    @Operation(summary = "Get all service offers")
    public List<ServiceOffer> getAllServices() {
        return serviceOfferService.getAllServices();
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get all service offers for a user")
    public List<ServiceOffer> getAllUserServices(@PathVariable Long userId) {
        return serviceOfferService.getAllUserServices(userId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a service offer by ID")
    public ServiceOffer getServiceById(@PathVariable Long id) {
        return serviceOfferService.getServiceById(id);
    }

    @PostMapping("{userId}")
    @Operation(summary = "Add a service offer")
    public ServiceOfferDto addServiceOffer(@PathVariable Long userId,@RequestBody ServiceOfferDto serviceOfferDto) {
        return serviceOfferService.setServiceDto(userId, serviceOfferDto);
    }
}
