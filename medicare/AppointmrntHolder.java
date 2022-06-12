package com.ruth.jahan.medicare;

public class AppointmrntHolder {
String blood,problem,time,date,serial,doctorname;

    public AppointmrntHolder() {
    }

    public AppointmrntHolder(String blood, String problem, String time, String date, String serial, String doctorname) {
        this.blood = blood;
        this.problem = problem;
        this.time = time;
        this.date = date;
        this.serial = serial;
        this.doctorname = doctorname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public AppointmrntHolder(String blood, String problem, String time) {
        this.blood = blood;
        this.problem = problem;
        this.time = time;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
