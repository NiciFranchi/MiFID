package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Questionnaire {
    @Id
    private Long id;

    private String name;
    private String authorFirstName;
    private String authorLastName;
    private Date dateOfCreation;

    public Questionnaire(String name, String authorFirstName, String authorLastName, Date dateOfCreation) {
        this.name = name;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.dateOfCreation = dateOfCreation;
    }

    public Questionnaire() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}