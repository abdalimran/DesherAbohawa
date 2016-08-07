
package com.github.abdalimran.desherabohawa.GeolookupPojoModels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Station {

    @SerializedName("neighborhood")
    @Expose
    private String neighborhood;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("distance_km")
    @Expose
    private int distanceKm;
    @SerializedName("distance_mi")
    @Expose
    private int distanceMi;

    /**
     * 
     * @return
     *     The neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * 
     * @param neighborhood
     *     The neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * 
     * @return
     *     The distanceKm
     */
    public int getDistanceKm() {
        return distanceKm;
    }

    /**
     * 
     * @param distanceKm
     *     The distance_km
     */
    public void setDistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }

    /**
     * 
     * @return
     *     The distanceMi
     */
    public int getDistanceMi() {
        return distanceMi;
    }

    /**
     * 
     * @param distanceMi
     *     The distance_mi
     */
    public void setDistanceMi(int distanceMi) {
        this.distanceMi = distanceMi;
    }

}
