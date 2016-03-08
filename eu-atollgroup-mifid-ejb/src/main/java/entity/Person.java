package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by u95599 on 2016.03.08.
 */
@Entity
public abstract class Person {
    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String birthPlace;
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
