
package com.github.abdalimran.desherabohawa.Forecast10dayPojoModels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class SnowNight {

    @SerializedName("in")
    @Expose
    private double in;
    @SerializedName("cm")
    @Expose
    private double cm;

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
     *     The cm
     */
    public double getCm() {
        return cm;
    }

    /**
     * 
     * @param cm
     *     The cm
     */
    public void setCm(double cm) {
        this.cm = cm;
    }

}
