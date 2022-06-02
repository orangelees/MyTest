package com.lqs.model;

/**
 * @author lqs
 * @date 2022/3/23 11:05
 */
public class Reserve {

    private String name;
    private String phone;
    private String address;
    private String datetime;
    private String state;
    private long reserveId;

    public long getReserveId() {
        return reserveId;
    }

    public void setReserveId(long reserveId) {
        this.reserveId = reserveId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Reserve(String name, String phone, String address, String datetime, String state, long reserveId) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.datetime = datetime;
        this.state = state;
        this.reserveId = reserveId;
    }

    public Reserve() {
    }
}
