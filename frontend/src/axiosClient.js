import axios from "axios";

// const axiosClient = axios.create({
//     baseURL: import.meta.env.VITE_API_BASE_URL
// });

const axiosClient = axios.create({
    baseURL: import.meta.env.VITE_API_TRAVEL_INFO_URL
});

export default axiosClient;