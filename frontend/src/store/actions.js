import { axiosClient } from "../axiosClient";

export function searchTravelInfo({ commit }, { country, page }) {
    axiosClient.get(`${country}?page=${page}&size=21`).then(
        ({ data }) => {
            commit('setTravelInfo', data)
        }
    )

}

export function searchCountryFlag({ commit }, countryIso) {
    commit('setCountryFlag', countryIso)
}

export function updateCountry({ commit }, country) {
    commit('setCountry', country)
}
