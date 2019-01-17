
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
    "from",
    "to"
})
public class Now implements Serializable
{

    @JsonProperty("from")
    private Double from;
    @JsonProperty("to")
    private Double to;
    private final static long serialVersionUID = -7305200373531929187L;

    @JsonProperty("from")
    public Double getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(Double from) {
        this.from = from;
    }

    @JsonProperty("to")
    public Double getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(Double to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("from", from).append("to", to).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(to).append(from).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Now) == false) {
            return false;
        }
        Now rhs = ((Now) other);
        return new EqualsBuilder().append(to, rhs.to).append(from, rhs.from).isEquals();
    }

}
