package com.airline.ticketservice.base.type;

public enum ResultCode {
    //NULL FIELDS
    COMPANY_NOT_FOUND(1000),

    //OPERATIONAL
    CREDIT_CARD_FORMAT_FALSE(2000);

    private Integer code;

    ResultCode(Integer code) {
        this.setCode(code);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
