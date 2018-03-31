package com.nurina.sani20;

public class Padi {


        private String nama;
        private String tipe;
        private int nilai;

        public Padi(String nama, String tipe, int nilai) {
            this.nama = nama;
            this.tipe = tipe;
            this.nilai = nilai;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getTipe() {
            return tipe;
        }

        public void setTipe(String tipe) {
            this.tipe = tipe;
        }

        public int getNilai() {
            return nilai;
        }

        public void setNilai(int nilai) {
            this.nilai = nilai;
        }
    }

