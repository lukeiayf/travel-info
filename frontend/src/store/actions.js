import axiosClient from "../axiosClient";

export function searchTravelInfo({ commit }, country) {
    axiosClient.get(`${country}?size=20`).then(
        ({ data }) => {
            commit('setTravelInfo', data.items)
        }
    )

}
