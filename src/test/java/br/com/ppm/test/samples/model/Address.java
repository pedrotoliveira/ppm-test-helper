package br.com.ppm.test.samples.model;

import java.util.Objects;

/**
 * The Address
 *
 * @author pedrotoliveira
 */
public class Address {

    private String street;
    private int number;
    private String complement;

    public Address(String street, int number, String complement) {
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.street);
        hash = 97 * hash + this.number;
        hash = 97 * hash + Objects.hashCode(this.complement);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.complement, other.complement)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", number=" + number + ", complement=" + complement + '}';
    }
   
}
