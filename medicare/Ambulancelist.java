package com.ruth.jahan.medicare;

public class Ambulancelist {
    private String ambuname;
    private String ambudriver;
    private String ambuphone;

    public Ambulancelist() {
    }

    public Ambulancelist(String ambuname, String ambudriver, String ambuphone) {
        this.ambuname = ambuname;
        this.ambudriver = ambudriver;
        this.ambuphone = ambuphone;
    }

    public String getAmbuname() {
        return ambuname;
    }

    public void setAmbuname(String ambuname) {
        this.ambuname = ambuname;
    }

    public String getAmbudriver() {
        return ambudriver;
    }

    public void setAmbudriver(String ambudriver) {
        this.ambudriver = ambudriver;
    }

    public String getAmbuphone() {
        return ambuphone;
    }

    public void setAmbuphone(String ambuphone) {
        this.ambuphone = ambuphone;
    }
}