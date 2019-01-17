
package com.zensar.beans;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "products"
})
public class ProductsBean implements Serializable
{

    @JsonProperty("products")
    private List<Product> products = null;
    private final static long serialVersionUID = 1014324233880391420L;

    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("products", products).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(products).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductsBean) == false) {
            return false;
        }
        ProductsBean rhs = ((ProductsBean) other);
        return new EqualsBuilder().append(products, rhs.products).isEquals();
    }

}
