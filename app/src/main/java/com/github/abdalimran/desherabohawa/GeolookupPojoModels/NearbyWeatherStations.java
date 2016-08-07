
package com.github.abdalimran.desherabohawa.GeolookupPojoModels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class NearbyWeatherStations {

    @SerializedName("airport")
    @Expose
    private Airport airport;
    @SerializedName("pws")
    @Expose
    private Pws pws;

    /**
     * 
     * @return
     *     The airport
     */
    public Airport getAirport() {
        return airport;
    }

    /**
     * 
     * @param airport
     *     The airport
     */
    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    /**
     * 
     * @return
     *     The pws
     */
    public Pws getPws() {
        return pws;
    }

    /**
     * 
     * @param pws
     *     The pws
     */
    public void setPws(Pws pws) {
        this.pws = pws;
    }

}
