package com.nurina.sani20;

public class ActivityHistory {

    private String penandaHari;
    private String Aktivitas;
    private String waktu;

    public ActivityHistory(String penandaHari, String Aktivitas, String waktu){
        this.penandaHari=penandaHari;
        this.Aktivitas=Aktivitas;
        this.waktu=waktu;
    }

    public String getPenandaHari() {
        return penandaHari;
    }

    public void setPenandaHari(String penandaHari) {
        this.penandaHari = penandaHari;
    }

    public String getAktivitas() {
        return Aktivitas;
    }

    public void setAktivitas(String aktivitas) {
        Aktivitas = aktivitas;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
