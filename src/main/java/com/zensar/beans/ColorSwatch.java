
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
    "color",
    "basicColor",
    "colorSwatchUrl",
    "imageUrl",
    "isAvailable",
    "skuId",
    "rgbColor"
})
public class ColorSwatch implements Serializable
{

    @JsonProperty("color")
    private String color;
    @JsonProperty("basicColor")
    private String basicColor;
    @JsonProperty("colorSwatchUrl")
    private String colorSwatchUrl;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("isAvailable")
    private Boolean isAvailable;
    @JsonProperty("skuId")
    private String skuId;
    @JsonProperty("rgbColor")
    private String rgbColor;
    private final static long serialVersionUID = 668505859743476359L;

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("basicColor")
    public String getBasicColor() {
        return basicColor;
    }

    @JsonProperty("basicColor")
    public void setBasicColor(String basicColor) {
        this.basicColor = basicColor;
    }

    @JsonProperty("colorSwatchUrl")
    public String getColorSwatchUrl() {
        return colorSwatchUrl;
    }

    @JsonProperty("colorSwatchUrl")
    public void setColorSwatchUrl(String colorSwatchUrl) {
        this.colorSwatchUrl = colorSwatchUrl;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("isAvailable")
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    @JsonProperty("isAvailable")
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @JsonProperty("skuId")
    public String getSkuId() {
        return skuId;
    }

    @JsonProperty("skuId")
    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("color", color).append("basicColor", basicColor).append("colorSwatchUrl", colorSwatchUrl).append("imageUrl", imageUrl).append("isAvailable", isAvailable).append("skuId", skuId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(imageUrl).append(color).append(skuId).append(basicColor).append(colorSwatchUrl).append(isAvailable).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ColorSwatch) == false) {
            return false;
        }
        ColorSwatch rhs = ((ColorSwatch) other);
        return new EqualsBuilder().append(imageUrl, rhs.imageUrl).append(color, rhs.color).append(skuId, rhs.skuId).append(basicColor, rhs.basicColor).append(colorSwatchUrl, rhs.colorSwatchUrl).append(isAvailable, rhs.isAvailable).isEquals();
    }

    @JsonProperty("rgbColor")
	public String getRgbColor() {
		return rgbColor;
	}

    @JsonProperty("rgbColor")
	public void setRgbColor(String rgbColor) {
		this.rgbColor = rgbColor;
	}

}
