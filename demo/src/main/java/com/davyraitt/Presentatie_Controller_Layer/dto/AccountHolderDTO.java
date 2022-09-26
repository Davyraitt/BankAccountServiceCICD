package com.davyraitt.Presentatie_Controller_Layer.dto;

public class AccountHolderDTO {
    private String name;
    private String bsn;

    public AccountHolderDTO() {
    }

    public AccountHolderDTO(String name, String bsn) {
        this.name = name;
        this.bsn = bsn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBsn() {
        return bsn;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    @Override
    public String toString() {
        return "AccountHolderDTO{" +
                "name='" + name + '\'' +
                ", bsn=" + bsn +
                '}';
    }
}
