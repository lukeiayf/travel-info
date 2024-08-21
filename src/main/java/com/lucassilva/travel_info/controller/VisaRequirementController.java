package com.lucassilva.travel_info.controller;

import com.lucassilva.travel_info.entity.VisaRequirement;
import com.lucassilva.travel_info.service.VisaRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/travel-info")
public class VisaRequirementController {
    @Autowired
    private VisaRequirementService visaRequirementService;

    @GetMapping("/passport/{passport}")
    public ResponseEntity<Flux<VisaRequirement>> getVisaRequirements(@PathVariable String passport, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Flux<VisaRequirement> data = visaRequirementService.getDestinationsForPassport(passport, page, size);
        return ResponseEntity.ok(data);
    }
}
