import axios from "axios";

const axiosClient = axios.create({
    baseURL: import.meta.env.VITE_API_TRAVEL_INFO_URL
});

export { axiosClient };