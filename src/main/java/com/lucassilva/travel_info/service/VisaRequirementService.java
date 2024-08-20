package com.lucassilva.travel_info.service;

import com.lucassilva.travel_info.entity.VisaRequirement;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisaRequirementService {

    private List<VisaRequirement> visaRequirements;

    @PostConstruct
    public void loadData() throws IOException {
        try (FileReader reader = new FileReader("src/main/resources/csv/passport-index-tidy-iso3.csv")) {
            visaRequirements = new CsvToBeanBuilder<VisaRequirement>(reader)
                    .withType(VisaRequirement.class)
                    .build()
                    .parse();
        }
    }

    public List<VisaRequirement> getDestinationsForPassport(String passport) {
        return visaRequirements.stream()
                .filter(vr -> vr.getPassport().equalsIgnoreCase(passport))
                .collect(Collectors.toList());
    }
}
