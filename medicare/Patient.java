package com.ruth.jahan.medicare;

public class Patient {

    String paddress,page,pemail,pgender,pname,pphone,type;

    public Patient() {
    }

    public Patient(String paddress, String page, String pemail, String pgender, String pname, String pphone, String type) {
        this.paddress = paddress;
        this.page = page;
        this.pemail = pemail;
        this.pgender = pgender;
        this.pname = pname;
        this.pphone = pphone;
        this.type = type;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public String getPgender() {
        return pgender;
    }

    public void setPgender(String pgender) {
        this.pgender = pgender;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
