
package com.github.abdalimran.desherabohawa.Forecast10dayPojoModels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class QpfDay {

    @SerializedName("in")
    @Expose
    private double in;
    @SerializedName("mm")
    @Expose
    private int mm;

    /**
     * 
     * @return
     *     The in
     */
    public double getIn() {
        return in;
    }

    /**
     * 
     * @param in
     *     The in
     */
    public void setIn(double in) {
        this.in = in;
    }

    /**
     * 
     * @return
     *     The mm
     */
    public int getMm() {
        return mm;
    }

    /**
     * 
     * @param mm
     *     The mm
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

}
