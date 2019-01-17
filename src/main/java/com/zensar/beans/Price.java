
package com.zensar.beans;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zensar.util.NowCustomSerializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "was",
    "then1",
    "then2",
    "now",
    "uom",
    "currency",
    "originalWas"
})
public class Price implements Serializable
{

    @JsonProperty("was")
    private Double was;
    @JsonProperty("then1")
    private Double then1;
    @JsonProperty("then2")
    private Double then2;
    @JsonDeserialize(using = NowCustomSerializer.class)
    @JsonProperty("now")
    private Now now;
    @JsonProperty("uom")
    private String uom;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("originalWas")
    private Double originalWas;
    private final static long serialVersionUID = -435642022805527837L;

    @JsonProperty("was")
    public Double getWas() {
        return was;
    }

    @JsonProperty("was")
    public void setWas(Double was) {
        this.was = was;
    }
    
    

    @JsonProperty("then1")
    public Double getThen1() {
        return then1;
    }

    @JsonProperty("then1")
    public void setThen1(Double then1) {
        this.then1 = then1;
    }

    @JsonProperty("then2")
    public Double getThen2() {
        return then2;
    }

    @JsonProperty("then2")
    public void setThen2(Double then2) {
        this.then2 = then2;
    }

    @JsonProperty("now")
    public Now getNow() {
        return now;
    }

    @JsonProperty("now")
    public void setNow(Now now) {
        this.now = now;
    }

    @JsonProperty("uom")
    public String getUom() {
        return uom;
    }

    @JsonProperty("uom")
    public void setUom(String uom) {
        this.uom = uom;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("was", was).append("then1", then1).append("then2", then2).append("now", now).append("uom", uom).append("currency", currency).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(uom).append(now).append(then2).append(then1).append(currency).append(was).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Price) == false) {
            return false;
        }
        Price rhs = ((Price) other);
        return new EqualsBuilder().append(uom, rhs.uom).append(now, rhs.now).append(then2, rhs.then2).append(then1, rhs.then1).append(currency, rhs.currency).append(was, rhs.was).isEquals();
    }

    @JsonProperty("originalWas")
	public Double getOriginalWas() {
		return originalWas;
	}

    @JsonProperty("originalWas")
	public void setOriginalWas(Double originalWas) {
		this.originalWas = originalWas;
	}

}
