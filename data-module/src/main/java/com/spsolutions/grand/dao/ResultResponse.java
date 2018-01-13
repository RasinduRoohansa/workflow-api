package com.spsolutions.grand.dao;

public class ResultResponse {
    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public ResultResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
