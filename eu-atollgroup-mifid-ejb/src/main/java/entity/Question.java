package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by u95599 on 2016.03.08.
 */

@Entity
@XmlRootElement(name = "question")
public class Question {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Questionnaire questionnaire;
    private String name;
    private String description;

    @OneToMany
    private List<Answer> answer;

    public Question(){
    }


    public Question(Questionnaire questionnaire, String name, String description) {
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

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }
}
