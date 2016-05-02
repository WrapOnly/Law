package com.handle.law.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/1.
 */
public class AddressBean  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int bDefault;
    private long addressId;
    private long accountId;
    private String country;
    private String state;
    private String city;
    private String district;
    private String address;
    private String zip;
    private String name;
    private String phone;

    public AddressBean() {
    }

    public AddressBean(int bDefault, long addressId, long accountId,
                        String state, String city, String district, String address,
                        String zip, String name, String phone) {
        this.bDefault = bDefault;
        this.addressId = addressId;
        this.accountId = accountId;
        this.state = state;
        this.city = city;
        this.district = district;
        this.address = address;
        this.zip = zip;
        this.name = name;
        this.phone = phone;
    }

    public AddressBean(String country, String state, String city, String district,
                        String address, String zip, String name, String phone) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.district = district;
        this.address = address;
        this.zip = zip;
        this.name = name;
        this.phone = phone;
    }

    public String getString() {
        return this.state+","+
                this.city+","+
                this.district+","+
                this.address+","+
                this.name+","+
                "邮编:"+this.zip;
    }

    public String getAddressString(){
        return this.state+this.city+this.district;
    }
    public ArrayList<String> getAsStrings() {
        ArrayList<String> al = new ArrayList<String>(0);
        al.add(Integer.toString(this.bDefault));
        al.add(Long.toString(this.addressId));
        al.add(Long.toString(this.accountId));
        al.add(this.state);
        al.add(this.city);
        al.add(this.district);
        al.add(this.address);
        al.add(this.zip);
        al.add(this.name);
        al.add(this.phone);
        return al;
    }

    public long getAddressId() {
        return addressId;
    }
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }
    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    public int getbDefault() {
        return bDefault;
    }
    public void setbDefault(int bDefault) {
        this.bDefault = bDefault;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
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

    @Override
    public String toString() {
        return this.state+this.city+this.district+this.address;
    }
}
