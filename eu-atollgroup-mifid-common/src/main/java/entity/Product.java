package entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by u95599 on 2016.03.08.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@javax.persistence.Table(name = "PRODUCTS")
@NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :productName")
@XmlRootElement
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String name;
    private String description;
    private boolean isQuestionnaireNeeded;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "product", cascade = {CascadeType.ALL})
    @JsonIgnore
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

    public boolean getIsQuestionnaireNeeded() {
        return isQuestionnaireNeeded;
    }

    public void setIsQuestionnaireNeeded(boolean isQuestionnaireNeeded) {
        this.isQuestionnaireNeeded = isQuestionnaireNeeded;
    }

    public Long getId() {
        return id;
    }
}
