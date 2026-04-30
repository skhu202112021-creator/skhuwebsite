import axios from "axios";

// 회원가입
export const join = (args) => { // ①
    return axios.post("/v1/api/account/join", args).catch(e => e.response);
};

// 로그인
export const login2 = (args) => { // ②
    return axios.post("/v1/api/account/login2", args).catch(e => e.response);
};

export const login1 = (args) => { // ②
    return axios.post("/v1/api/account/login1", args).catch(e => e.response);
};

// 로그인 여부 확인
export const check = () => { // ③
    return axios.get("/v1/api/account/check").catch(e => e.response);
};

// 로그아웃
export const logout = () => { // ④
    return axios.post("/v1/api/account/logout").catch(e => e.response);
};