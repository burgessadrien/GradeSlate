package com.gradeslate.gradeslate.backend;

import com.gradeslate.gradeslate.BuildConfig;
import java.io.Serializable;

public class Professor extends Person implements Serializable {
    private String offHour = "Hour";
    private int offLen;
    private String offLoc = "Location";

    Professor() {

    }

    public void setOffLoc(String location) {
        this.offLoc = location;
    }

    public String getOffLoc() {
        return this.offLoc;
    }

    public void setOffHour(String offHour) {
        this.offHour = offHour;
    }

    public String getOffHour() {
        return this.offHour;
    }

    public void setOffLen(int length) {
        this.offLen = length;
    }

    public int getOffLen() {
        return this.offLen;
    }
}
