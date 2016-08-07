
package com.github.abdalimran.desherabohawa.GeolookupPojoModels;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Pws {

    @SerializedName("station")
    @Expose
    private List<Station> station = new ArrayList<Station>();

    /**
     * 
     * @return
     *     The station
     */
    public List<Station> getStation() {
        return station;
    }

    /**
     * 
     * @param station
     *     The station
     */
    public void setStation(List<Station> station) {
        this.station = station;
    }

}
