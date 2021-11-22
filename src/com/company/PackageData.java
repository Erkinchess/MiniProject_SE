package com.company;

import java.io.Serializable;
import java.util.ArrayList;

// === PackageData === //

public class PackageData implements Serializable {
    private String operationType;
    private Student stud;
    private ArrayList<Student> studs;

    public PackageData() {
        this.operationType = "None";
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String type_name) {
        this.operationType = type_name;
    }

    public ArrayList<Student> getStuds() {
        return studs;
    }

    public void setStuds(ArrayList<Student> studs) {
        this.studs = studs;
    }

    public void setStud(Student stud) {
        this.stud = stud;
    }

    public Student getStud() {
        return stud;
    }
}
