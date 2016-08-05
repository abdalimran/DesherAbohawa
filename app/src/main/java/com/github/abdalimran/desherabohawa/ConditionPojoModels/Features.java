
package com.github.abdalimran.desherabohawa.ConditionPojoModels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Features {

    @SerializedName("conditions")
    @Expose
    private int conditions;

    /**
     * 
     * @return
     *     The conditions
     */
    public int getConditions() {
        return conditions;
    }

    /**
     * 
     * @param conditions
     *     The conditions
     */
    public void setConditions(int conditions) {
        this.conditions = conditions;
    }

}
