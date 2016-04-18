package entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by u95599 on 2016.03.08.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@javax.persistence.Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private boolean isQuestionnaireNeeded;

    @OneToOne
    private Questionnaire questionnaire;

    @ManyToMany
    private List<Customer> customerList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public boolean isQuestionnaireNeeded() {
        return isQuestionnaireNeeded;
    }

    public void setQuestionnaireNeeded(boolean questionnaireNeeded) {
        isQuestionnaireNeeded = questionnaireNeeded;
    }

    public Long getId() {
        return id;
    }
}
