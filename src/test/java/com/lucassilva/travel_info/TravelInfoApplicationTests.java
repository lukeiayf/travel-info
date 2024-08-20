package com.lucassilva.travel_info;

import com.lucassilva.travel_info.entity.VisaRequirement;
import com.lucassilva.travel_info.service.VisaRequirementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TravelInfoApplicationTests {

	private VisaRequirementService visaRequirementService;

	@BeforeEach
	void setUp() throws IOException {
		visaRequirementService = new VisaRequirementService();
		visaRequirementService.loadData();
	}

	@Test
	void testGetDestinationsForPassport_Found() {
		String passport = "USA";
		List<VisaRequirement> results = visaRequirementService.getDestinationsForPassport(passport);

		assertEquals(199, results.size());
		assertEquals("ALB", results.getFirst().getDestination());
	}

	@Test
	void testGetDestinationsForPassport_NotFound() {
		String passport = "INVALID_COUNTRY";
		List<VisaRequirement> results = visaRequirementService.getDestinationsForPassport(passport);

		assertEquals(0, results.size());
	}

}
