package com.lucassilva.travel_info.controller;

import com.lucassilva.travel_info.entity.VisaRequirement;
import com.lucassilva.travel_info.service.VisaRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/travel-info")
public class VisaRequirementController {
    @Autowired
    private VisaRequirementService visaRequirementService;

    @GetMapping("/passport/{passport}")
    public List<VisaRequirement> getDestinations(@PathVariable String passport) {
        return visaRequirementService.getDestinationsForPassport(passport);
    }
}
