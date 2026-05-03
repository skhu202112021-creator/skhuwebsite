import axios from "axios";

export const list = (args) => {
    return axios.post("/v1/api/subject/list", args).catch(e => e.response);
};