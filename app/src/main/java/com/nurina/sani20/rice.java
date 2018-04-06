package com.nurina.sani20;

public class rice {

    private String riceType;
    private int ricePrice;
    private String ricePerBerapa;
    private int IdIconHarga;

    public rice(int h, String riceType, int ricePrice, String ricePerBerapa) {
        this.riceType = riceType;
        this.ricePrice = ricePrice;
        this.ricePerBerapa = ricePerBerapa;
        this.IdIconHarga = h;
    }
    public int getIdIconHarga() { return IdIconHarga; }

    public void setIdIconHarga(int idIconHarga) { IdIconHarga = idIconHarga; }

    public String getRiceType() {
            return riceType;
        }

    public void setRiceType(String riceType) {
            this.riceType = riceType;
        }

    public int getRicePrice() {
            return ricePrice;
        }

    public void setRicePrice(int ricePrice) {
            this.ricePrice = ricePrice;
        }

    public String getRicePerBerapa() {
            return ricePerBerapa;
        }

    public void setRicePerBerapa(String ricePerBerapa) {
            this.ricePerBerapa = ricePerBerapa;
        }
}


