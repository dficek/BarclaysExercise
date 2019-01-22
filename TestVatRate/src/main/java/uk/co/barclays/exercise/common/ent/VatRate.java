package uk.co.barclays.exercise.common.ent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Main entity with VAT Rate
 *
 * @author Ficek Daniel
 */
public class VatRate implements Serializable {

    private static final long serialVersionUID = -4763119013595232739L;

    // Name of the country
    private String name;
    // VAT rate
    private BigDecimal rate;

    /**
     * The constructor.
     *
     * @param name Country name
     * @param rate VAT rate
     */
    public VatRate(String name, BigDecimal rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatRate vatRate = (VatRate) o;
        return Objects.equals(getName(), vatRate.getName()) &&
                Objects.equals(getRate(), vatRate.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRate());
    }

    @Override
    public String toString() {
        return "JsonVatRate{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }

}
