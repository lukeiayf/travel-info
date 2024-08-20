package com.lucassilva.travel_info.entity;

public class VisaRequirement {
    private String passport;
    private String destination;
    private String requirement;

    public VisaRequirement() {}

    public VisaRequirement(String passport, String destination, String requirement) {
        this.passport = passport;
        this.destination = destination;
        this.requirement = requirement;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
}
