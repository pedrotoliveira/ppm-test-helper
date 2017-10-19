package br.com.ppm.test.model;

import java.util.Objects;

/**
 * The Address
 *
 * @author pedrotoliveira
 */
public class Address {

    private String street;
    private String city;
    private Integer number;
    private String state;
    private String zipcode;
    private String country;
    private String complement;

    public Address(String street, String city, Integer number, String state, String zipcode, String country) {
        this.street = street;
        this.city = city;
        this.number = number;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.street);
        hash = 17 * hash + Objects.hashCode(this.city);
        hash = 17 * hash + Objects.hashCode(this.number);
        hash = 17 * hash + Objects.hashCode(this.state);
        hash = 17 * hash + Objects.hashCode(this.zipcode);
        hash = 17 * hash + Objects.hashCode(this.country);
        hash = 17 * hash + Objects.hashCode(this.complement);
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
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zipcode, other.zipcode)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.complement, other.complement)) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", city=" + city + ", number=" + number + ", state=" + state + ", zipcode=" + zipcode + ", country=" + country + ", complement=" + complement + '}';
    }

}
