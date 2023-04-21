package com.example.gundurisamushao.model.remote.brewery;

public class Brewery {

    public String id;
    public String name;
    public String brewery_type;
    public String address_1;
    public String country;
    public String city;
    public long phone;
    public String website_url;

    public Brewery(String id, String name, String brewery_type, String address_1, String country, String city, long phone, String website_url) {
        this.id = id;
        this.name = name;
        this.brewery_type = brewery_type;
        this.address_1 = address_1;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.website_url = website_url;
    }
}
