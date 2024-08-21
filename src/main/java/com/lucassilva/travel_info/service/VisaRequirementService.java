package com.lucassilva.travel_info.service;

import com.lucassilva.travel_info.entity.VisaRequirement;
import com.lucassilva.travel_info.model.response.PaginatedResponse;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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

    @Cacheable("visaRequirements")
    public Mono<PaginatedResponse<VisaRequirement>> getDestinationsForPassport(String passport, int page, int size) {
        List<VisaRequirement> filtered = visaRequirements.stream()
                .filter(vr -> vr.getPassport().equalsIgnoreCase(passport))
                .toList();

        int start = page * size;
        int end = Math.min(start + size, filtered.size());
        List<VisaRequirement> paginatedList = filtered.subList(start, end);

        PaginatedResponse<VisaRequirement> response = new PaginatedResponse<>(
                paginatedList, filtered.size(), page, size);
        return Mono.just(response);
    }
}
