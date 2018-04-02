package com.nurina.sani20;

public class Seed {

    private String padiType;
    private int seedPrice;
    private String seedPerBerapa;

    public Seed(String padiType, int seedPrice, String seedPerBerapa) {
        this.padiType = padiType;
        this.seedPrice = seedPrice;
        this.seedPerBerapa = seedPerBerapa;
    }

    public String getPadiType() {
        return padiType;
    }

    public void setPadiType(String padiType) {
        this.padiType = padiType;
    }

    public int getSeedPrice() {
        return seedPrice;
    }

    public void setSeedPrice(int seedPrice) {
        this.seedPrice = seedPrice;
    }

    public String getSeedPerBerapa() {
        return seedPerBerapa;
    }

    public void setSeedPerBerapa(String seedPerBerapa) {
        this.seedPerBerapa = seedPerBerapa;
    }
}
