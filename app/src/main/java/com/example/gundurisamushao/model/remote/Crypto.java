package com.example.gundurisamushao.model.remote;

import com.google.gson.annotations.SerializedName;



public class Crypto {

    public int rank;
    @SerializedName("id")
    public String idn;
    public String name;
    public String symbol;
    public String description;
    public String started_at;
    public String logo;

    public Crypto(int rank, String idn, String name, String symbol, String description, String logo, String started_at) {
        this.rank = rank;
        this.idn = idn;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
        this.started_at = started_at;
        this.logo = logo;
    }


}
