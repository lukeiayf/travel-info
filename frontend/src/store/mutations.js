export function setTravelInfo(state, travelInfo) {
    state.travelInfo = travelInfo || [];
}

export function setCountry(state, country) {
    state.country = country || "";
}

export function setCountryFlag(state, countryIso) {
    state.countryIso = countryIso || "";
}