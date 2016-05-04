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
@javax.persistence.Table(name = "QUESTIONS")
@XmlRootElement
public class Question {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JsonIgnore
    private Questionnaire questionnaire;

    private String name;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Answer> answers;

    public Question(){
    }


    public Question(Questionnaire questionnaire, String name, String description) {
        this.questionnaire = questionnaire;
        this.name = name;
        this.description = description;
    }

    public Question(String name, String description) {
        this.questionnaire = questionnaire;
        this.name = name;
        this.description = description;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer){
        answer.setQuestion(this);
        this.answers.add(answer);
    }

}
