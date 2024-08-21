package com.lucassilva.travel_info.service;

import com.lucassilva.travel_info.entity.VisaRequirement;
import com.lucassilva.travel_info.model.response.AbstractPaginatedResponse;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class VisaRequirementService {

    private List<VisaRequirement> visaRequirements;

    @PostConstruct
    public void loadData() throws IOException {
        try (FileReader reader = new FileReader("src/main/resources/csv/passport-index-tidy.csv")) {
            visaRequirements = new CsvToBeanBuilder<VisaRequirement>(reader)
                    .withType(VisaRequirement.class)
                    .build()
                    .parse();
        }
    }

    @Cacheable("visaRequirements")
    public Mono<AbstractPaginatedResponse<VisaRequirement>> getDestinationsForPassport(String passport, int page, int size) {
        List<VisaRequirement> filtered = visaRequirements.stream()
                .filter(vr -> vr.getPassport().equalsIgnoreCase(passport))
                .toList();

        int start = page * size;
        int end = Math.min(start + size, filtered.size());
        List<VisaRequirement> paginatedList = filtered.subList(start, end);

        AbstractPaginatedResponse<VisaRequirement> response = new AbstractPaginatedResponse<>(
                paginatedList, filtered.size(), page, size);
        return Mono.just(response);
    }
}
