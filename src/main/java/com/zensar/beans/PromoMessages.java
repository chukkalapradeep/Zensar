
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
    "priceMatched",
    "offer",
    "customPromotionalMessage",
    "bundleHeadline",
    "customSpecialOffer"
})
public class PromoMessages implements Serializable
{

    @JsonProperty("priceMatched")
    private String priceMatched;
    @JsonProperty("offer")
    private String offer;
    @JsonProperty("customPromotionalMessage")
    private String customPromotionalMessage;
    @JsonProperty("bundleHeadline")
    private String bundleHeadline;
    @JsonProperty("customSpecialOffer")
    private CustomSpecialOffer customSpecialOffer;
    private final static long serialVersionUID = 9075936843475613804L;

    @JsonProperty("priceMatched")
    public String getPriceMatched() {
        return priceMatched;
    }

    @JsonProperty("priceMatched")
    public void setPriceMatched(String priceMatched) {
        this.priceMatched = priceMatched;
    }

    @JsonProperty("offer")
    public String getOffer() {
        return offer;
    }

    @JsonProperty("offer")
    public void setOffer(String offer) {
        this.offer = offer;
    }

    @JsonProperty("customPromotionalMessage")
    public String getCustomPromotionalMessage() {
        return customPromotionalMessage;
    }

    @JsonProperty("customPromotionalMessage")
    public void setCustomPromotionalMessage(String customPromotionalMessage) {
        this.customPromotionalMessage = customPromotionalMessage;
    }

    @JsonProperty("bundleHeadline")
    public String getBundleHeadline() {
        return bundleHeadline;
    }

    @JsonProperty("bundleHeadline")
    public void setBundleHeadline(String bundleHeadline) {
        this.bundleHeadline = bundleHeadline;
    }

    @JsonProperty("customSpecialOffer")
    public CustomSpecialOffer getCustomSpecialOffer() {
        return customSpecialOffer;
    }

    @JsonProperty("customSpecialOffer")
    public void setCustomSpecialOffer(CustomSpecialOffer customSpecialOffer) {
        this.customSpecialOffer = customSpecialOffer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("priceMatched", priceMatched).append("offer", offer).append("customPromotionalMessage", customPromotionalMessage).append("bundleHeadline", bundleHeadline).append("customSpecialOffer", customSpecialOffer).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(priceMatched).append(bundleHeadline).append(customSpecialOffer).append(customPromotionalMessage).append(offer).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PromoMessages) == false) {
            return false;
        }
        PromoMessages rhs = ((PromoMessages) other);
        return new EqualsBuilder().append(priceMatched, rhs.priceMatched).append(bundleHeadline, rhs.bundleHeadline).append(customSpecialOffer, rhs.customSpecialOffer).append(customPromotionalMessage, rhs.customPromotionalMessage).append(offer, rhs.offer).isEquals();
    }

}
