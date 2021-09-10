package com.spring.enity;

public class Dept {
    private  int Id;
    private  String Dname;
    private  String Local;

    public Dept(int id, String dname, String local) {
        Id = id;
        Dname = dname;
        Local = local;
    }

    public Dept() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }
}
