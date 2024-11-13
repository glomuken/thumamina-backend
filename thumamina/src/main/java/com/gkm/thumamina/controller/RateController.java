package com.gkm.thumamina.controller;

import com.gkm.thumamina.model.dto.RateDto;
import com.gkm.thumamina.service.RateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rate")
@RequiredArgsConstructor
@Tag(name = "Rate Setting API")
public class RateController {

    private final RateService rateService;

    @PatchMapping("{userId}")
    @Operation
    public RateDto updateRateDetails(@PathVariable Long userId, @RequestBody RateDto rateDto){
       return rateService.updateRate(userId,rateDto);
    }

}
