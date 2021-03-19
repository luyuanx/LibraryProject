package com.it.po;

import java.io.Serializable;

public class ClassInfo implements Serializable {
    private Integer id;
    private String name;
    private String remarks;



    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    private int counts;



    public ClassInfo() {
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
