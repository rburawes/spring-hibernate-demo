package com.demo.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Holds the {@link Author} details associated with the {@link Book}.
 *
 * @author rburawes
 */
@Entity
@Table(name = "author", schema = "store")
public class Author extends Modifiable {

    @Column(name = "given_name", nullable = false)
    private String givenName;

    @Column(name = "family_name", nullable = false)
    private String familyName;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public int hashCode() {
        return new Long(getId()).hashCode() * givenName.hashCode() * familyName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Author)) {
            return false;
        }

        Author other = (Author) obj;

        if (this.getId() != other.getId()) {
            return false;
        }

        if (!this.givenName.equals(other.getGivenName())) {
            return false;
        }

        if (!this.familyName.equals(other.getGivenName())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }
}
