package com.nurina.sani20;

import java.util.Date;

public class Padi {

        private String id;
        private String nama;
        private String dateStart;
        private String dateEnd;
        private String dayRemaining;
        private int progress;

        public Padi (){

        }

        public Padi(String id, String nama, String dateStart, String dateEnd, String dayRemaining   , int progress) {
            this.id = id;
            this.nama = nama;
            this.dateStart = dateStart;
            this.dateEnd = dateEnd;
            this.dayRemaining = dayRemaining;
            this.progress = progress;
        }


        public int getProgress() {
                return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public String getDayRemaining() {
            return dayRemaining;
        }

        public void setDayRemaining(String dayRemaining) {
            this.dayRemaining = dayRemaining;
        }

        public Padi(String nama) {
                this.nama = nama;
            }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public void setDateStart(String dateStart) {
            this.dateStart = dateStart;
        }
        public String getDateStart() {
            return dateStart;
        }

        public String getDateEnd() {
            return dateEnd;
        }

        public void setDateEnd(String dateEnd) {
            this.dateEnd = dateEnd;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
}

