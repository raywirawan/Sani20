package com.nurina.sani20;

public class Seed {
    private String tipe;
    private String nama;
    private String harga;
    private String panen;

    public Seed() {
    }

    public Seed(String nama, String  harga) {
        this.nama = nama;
        this.harga = harga;
    }
    public Seed(String t, String n, String h, String p){
        this.tipe = t;
        this.nama = n;
        this.harga = h;
        this.panen = p;
    }
    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = Long.toString(harga);
    }

    public String getPanen() {
        return panen;
    }

    public void setPanen(long panen) {
        this.panen = Long.toString(panen);
    }
}
