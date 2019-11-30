package com.onebooming.boecloudservice.bean;

/**
 * @author Onebooming
 * @apiNote 2019/11/10
 */

public class RespBean {
    private String status;//状态
    private String msg;//MSG命令是向用户发送消息


    public RespBean() {
    }



    public RespBean(String status, String msg) {
        this.status = status;
        this.msg = msg;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
