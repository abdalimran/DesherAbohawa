
package com.github.abdalimran.desherabohawa.Forecast10dayPojoModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Avewind {

    @SerializedName("mph")
    @Expose
    private int mph;
    @SerializedName("kph")
    @Expose
    private int kph;
    @SerializedName("dir")
    @Expose
    private String dir;
    @SerializedName("degrees")
    @Expose
    private int degrees;

    /**
     * 
     * @return
     *     The mph
     */
    public int getMph() {
        return mph;
    }

    /**
     * 
     * @param mph
     *     The mph
     */
    public void setMph(int mph) {
        this.mph = mph;
    }

    /**
     * 
     * @return
     *     The kph
     */
    public int getKph() {
        return kph;
    }

    /**
     * 
     * @param kph
     *     The kph
     */
    public void setKph(int kph) {
        this.kph = kph;
    }

    /**
     * 
     * @return
     *     The dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * 
     * @param dir
     *     The dir
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * 
     * @return
     *     The degrees
     */
    public int getDegrees() {
        return degrees;
    }

    /**
     * 
     * @param degrees
     *     The degrees
     */
    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

}
