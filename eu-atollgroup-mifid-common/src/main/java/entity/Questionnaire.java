package entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@javax.persistence.Table(name = "QUESTIONNAIRES")
@XmlRootElement(name="questionnaire")
@XmlAccessorType(XmlAccessType.FIELD)
public class Questionnaire {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    @XmlElement
    private String name;
    @XmlElement
    private String description;
    @XmlElement
    private String authorFirstName;
    @XmlElement
    private String authorLastName;
    @XmlElement
    private int minScoreToAccept;
    @Temporal(TemporalType.DATE)
    @XmlElement
    private Date dateOfCreation;

    @Temporal(TemporalType.DATE)
    @XmlElement
    private Date dateOfLastModification;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionnaire", cascade = {CascadeType.ALL}, orphanRemoval=true)
    @XmlElement
    private List<Question> questions;

    @OneToOne
    @XmlElement
    private Product product;

    public Questionnaire(String name, String authorFirstName, String authorLastName, Date dateOfCreation) {
        this.name = name;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.dateOfCreation = dateOfCreation;
        this.questions= new ArrayList<>();
    }

    public Questionnaire() {
        this.questions= new ArrayList<>();
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getMinScoreToAccept() {
        return minScoreToAccept;
    }

    public void setMinScoreToAccept(int minScoreToAccept) {
        this.minScoreToAccept = minScoreToAccept;
    }

    public void addQuestion(Question question){
        question.setQuestionnaire(this);
        if(!this.questions.contains(question)){
            this.questions.add(question);
        }
    }

    public Date getDateOfLastModification() {
        return dateOfLastModification;
    }

    public void setDateOfLastModification(Date dateOfLastModification) {
        this.dateOfLastModification = dateOfLastModification;
    }
}