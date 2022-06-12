package com.ruth.jahan.medicare;

public class Doctorslist {
    private String docname;
    private String docdegree;
    private String docspeciality;
    private String docemail;
    private String docphone;
    private String depertmentspinner;

    public Doctorslist(){

    }

    public Doctorslist(String docname, String docdegree, String docspeciality, String docemail, String docphone, String depertmentspinner) {
        this.docname = docname;
        this.docdegree = docdegree;
        this.docspeciality = docspeciality;
        this.docemail = docemail;
        this.docphone = docphone;
        this.depertmentspinner = depertmentspinner;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocdegree() {
        return docdegree;
    }

    public void setDocdegree(String docdegree) {
        this.docdegree = docdegree;
    }

    public String getDocspeciality() {
        return docspeciality;
    }

    public void setDocspeciality(String docspeciality) {
        this.docspeciality = docspeciality;
    }

    public String getDocemail() {
        return docemail;
    }

    public void setDocemail(String docemail) {
        this.docemail = docemail;
    }

    public String getDocphone() {
        return docphone;
    }

    public void setDocphone(String docphone) {
        this.docphone = docphone;
    }

    public String getDepertmentspinner() {
        return depertmentspinner;
    }

    public void setDepertmentspinner(String depertmentspinner) {
        this.depertmentspinner = depertmentspinner;
    }
}
