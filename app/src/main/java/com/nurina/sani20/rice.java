package com.nurina.sani20;

public class rice {

    private String nama;
    private int harga;

    public rice() {

    }

    public rice(int h, String riceType, int ricePrice, String ricePerBerapa) {
        this.nama = riceType;
        this.harga = ricePrice;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}


