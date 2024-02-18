package com.jonathan.week3individualhealthassessmentprogram.datamodel;

import java.io.Serializable;

public class CholesterolData implements Serializable {

    private static final long serialVersionUID = 1L;
    private int cholesterol;
    private int triglycerides;
    private int hdl;
    private int ldl;

    private String cholesterolCategory;
    private String triglyceridesCategory;
    private String hdlCategory;
    private String ldlCategory;

    public CholesterolData() {
    }

    public boolean setCholesterol(int cholesterol) {
        if (cholesterol > 0 && cholesterol < 600) {
            this.cholesterol = cholesterol;
            return true;
        } else {
            return false;
        }
    }

    public boolean setTriglycerides(int triglycerides) {
        if (triglycerides >= 0 && triglycerides < 1000) {
            this.triglycerides = triglycerides;
            return true;
        } else {
            return false;
        }
    }

    public boolean setHDL(int hdl) {
        if (hdl >= 0 && hdl <= 100) {
            this.hdl = hdl;
            return true;
        } else {
            return false;
        }
    }

    public boolean setLDL(int ldl) {
        if (ldl >= 0 && ldl < 200) {
            this.ldl = ldl;
            return true;
        } else {
            return false;
        }
    }

    public void setCholesterolCategory(String cholesterolCategory) {
        this.cholesterolCategory = cholesterolCategory;
    }

    public void setTriglyceridesCategory(String triglyceridesCategory) {
        this.triglyceridesCategory = triglyceridesCategory;
    }

    public void setHdlCategory(String hdlCategory) {
        this.hdlCategory = hdlCategory;
    }

    public void setLdlCategory(String ldlCategory) {
        this.ldlCategory = ldlCategory;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public int getTriglycerides() {
        return triglycerides;
    }

    public int getHdl() {
        return hdl;
    }

    public int getLdl() {
        return ldl;
    }

    public String getCholesterolCategory() {
        return cholesterolCategory;
    }

    public String getTriglyceridesCategory() {
        return triglyceridesCategory;
    }

    public String getHdlCategory() {
        return hdlCategory;
    }

    public String getLdlCategory() {
        return ldlCategory;
    }
}
