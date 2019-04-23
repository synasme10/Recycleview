package com.recyclebin;

public class Contacts {
    private String name;
    private String phoneNo;
    private  int imageId;
    private String address;
    private String email;

    public Contacts(String name, String phoneNo, String address, String email ,int imageId) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.imageId = imageId;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

