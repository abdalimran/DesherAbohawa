
package com.github.abdalimran.desherabohawa.GeolookupPojoModels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Features {

    @SerializedName("geolookup")
    @Expose
    private int geolookup;

    /**
     * 
     * @return
     *     The geolookup
     */
    public int getGeolookup() {
        return geolookup;
    }

    /**
     * 
     * @param geolookup
     *     The geolookup
     */
    public void setGeolookup(int geolookup) {
        this.geolookup = geolookup;
    }

}
