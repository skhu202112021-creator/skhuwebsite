import axios from "axios";

export const list = (args) => {
    return axios.post("/v1/api/subject/list", args).catch(e => e.response);
};

export const listCheck = (args) => {
    return axios.post("/v1/api/subject/listCheck", args).catch(e => e.response);
};

export const list2 = (args) => {
    return axios.post("/v1/api/subject/list2", args).catch(e => e.response);
};

export const listCheck2 = (args) => {
    return axios.post("/v1/api/subject/listCheck2", args).catch(e => e.response);
};

export const save = (args) => {
    return axios.post("/v1/api/subject/save", args).catch(e => e.response);
};