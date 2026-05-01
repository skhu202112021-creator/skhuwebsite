import axios from "axios";

// 회원가입
export const join2 = (args) => {
    return axios.post("/v1/api/account/join2", args).catch(e => e.response);
};

export const join1 = (args) => { // ①
    return axios.post("/v1/api/account/join1", args).catch(e => e.response);
};

// 로그인
export const login2 = (args) => {
    return axios.post("/v1/api/account/login2", args).catch(e => e.response);
};

export const login1 = (args) => {
    return axios.post("/v1/api/account/login1", args).catch(e => e.response);
};

// 로그인 여부 확인
export const check = () => {
    return axios.get("/v1/api/account/check").catch(e => e.response);
};

// 로그아웃
export const logout = () => {
    return axios.post("/v1/api/account/logout").catch(e => e.response);
};