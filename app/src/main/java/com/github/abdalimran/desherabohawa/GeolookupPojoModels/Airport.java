
package com.github.abdalimran.desherabohawa.GeolookupPojoModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Airport {

    @SerializedName("station")
    @Expose
    private List<Object> station = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The station
     */
    public List<Object> getStation() {
        return station;
    }

    /**
     * 
     * @param station
     *     The station
     */
    public void setStation(List<Object> station) {
        this.station = station;
    }

}
