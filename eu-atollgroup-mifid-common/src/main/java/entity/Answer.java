package entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.*;

/**
 * Created by u95599 on 2016.03.08.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@javax.persistence.Table(name = "ANSWERS")
@XmlRootElement(name="answer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    @XmlElement
    private String name;
    @XmlElement
    private int score;

    @ManyToOne
    @JsonIgnore
    @XmlElement
    @XmlTransient
    private Question question;

    public Answer(){
    }

    public Answer(Question question, String name) {
        this.question = question;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
