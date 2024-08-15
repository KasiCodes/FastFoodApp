package com.myfastfoodapp.FastFoodVoucherw.dto;

public class StoreDTO {

    private Long id;
    private String name;
    private String location;

    public StoreDTO(Long id2, String name2, String location2) {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
}