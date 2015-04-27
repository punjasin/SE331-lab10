package camt.se331.shoppingcart.entity;

import javax.persistence.*;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class SelectedProduct {
    @Id
    @GeneratedValue
    Long id;
    @OneToOne
    Product product;
    Integer amount;

    public Double getTotalPrice(){
        return 0.0;
    }

    public SelectedProduct() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectedProduct that = (SelectedProduct) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return !(amount != null ? !amount.equals(that.amount) : that.amount != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SelectedProduct(Product product, Integer amount) {

        this.product = product;
        this.amount = amount;

    }
}
