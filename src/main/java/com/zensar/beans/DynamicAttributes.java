
package com.zensar.beans;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "newinproducttype",
    "washinginstructions",
    "dressbyoccasion",
    "dressshape",
    "typeofpattern"
})
public class DynamicAttributes implements Serializable
{

    @JsonProperty("newinproducttype")
    private String newinproducttype;
    @JsonProperty("washinginstructions")
    private String washinginstructions;
    @JsonProperty("dressbyoccasion")
    private String dressbyoccasion;
    @JsonProperty("dressshape")
    private String dressshape;
    @JsonProperty("typeofpattern")
    private String typeofpattern;
    private final static long serialVersionUID = 8336345574211423718L;

    @JsonProperty("newinproducttype")
    public String getNewinproducttype() {
        return newinproducttype;
    }

    @JsonProperty("newinproducttype")
    public void setNewinproducttype(String newinproducttype) {
        this.newinproducttype = newinproducttype;
    }

    @JsonProperty("washinginstructions")
    public String getWashinginstructions() {
        return washinginstructions;
    }

    @JsonProperty("washinginstructions")
    public void setWashinginstructions(String washinginstructions) {
        this.washinginstructions = washinginstructions;
    }

    @JsonProperty("dressbyoccasion")
    public String getDressbyoccasion() {
        return dressbyoccasion;
    }

    @JsonProperty("dressbyoccasion")
    public void setDressbyoccasion(String dressbyoccasion) {
        this.dressbyoccasion = dressbyoccasion;
    }

    @JsonProperty("dressshape")
    public String getDressshape() {
        return dressshape;
    }

    @JsonProperty("dressshape")
    public void setDressshape(String dressshape) {
        this.dressshape = dressshape;
    }

    @JsonProperty("typeofpattern")
    public String getTypeofpattern() {
        return typeofpattern;
    }

    @JsonProperty("typeofpattern")
    public void setTypeofpattern(String typeofpattern) {
        this.typeofpattern = typeofpattern;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("newinproducttype", newinproducttype).append("washinginstructions", washinginstructions).append("dressbyoccasion", dressbyoccasion).append("dressshape", dressshape).append("typeofpattern", typeofpattern).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(newinproducttype).append(washinginstructions).append(dressbyoccasion).append(dressshape).append(typeofpattern).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DynamicAttributes) == false) {
            return false;
        }
        DynamicAttributes rhs = ((DynamicAttributes) other);
        return new EqualsBuilder().append(newinproducttype, rhs.newinproducttype).append(washinginstructions, rhs.washinginstructions).append(dressbyoccasion, rhs.dressbyoccasion).append(dressshape, rhs.dressshape).append(typeofpattern, rhs.typeofpattern).isEquals();
    }

}
