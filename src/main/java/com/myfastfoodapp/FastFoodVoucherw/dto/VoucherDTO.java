package com.myfastfoodapp.FastFoodVoucherw.dto;

public class VoucherDTO {
    private Long id;
    private String code;
    private Double value;
    private String expirationDate;
    private Long storeId;
    private Long userId;


    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return code;
    }
    public void setValue(Double value){
        this.value = value;
    }
    public Double getValue(){
        return value;
    }
    public void setExpiaryDate(String expireDate){
        this.expirationDate = expireDate;
    }
    public String getExpirationDate(){
        return expirationDate;
    }
    public void setStoreId(Long storeId){
        this.storeId = storeId;
    }
    public Long getStoreId(){
        return storeId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public Long getUserId(){
        return userId;
    }


    
}
