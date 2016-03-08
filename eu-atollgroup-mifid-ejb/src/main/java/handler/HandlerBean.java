package handler;

import dal.AnswerFacade;
import dal.QuestionFacade;
import dal.QuestionnaireFacade;
import entity.Answer;
import entity.Question;
import entity.Questionnaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by u95599 on 2016.03.08.
 */

@Stateless
public class HandlerBean {

    @EJB
    QuestionnaireFacade questionnaireFacade;

    @EJB
    QuestionFacade questionFacade;

    @EJB
    AnswerFacade answerFacade;


    public void addQuestionnaire(Questionnaire questionnaire){
        questionnaireFacade.create(questionnaire);
    }

    public void addQuestion(Long questionnaireId, String name, String description) {
        Questionnaire questionnaire = questionnaireFacade.find(questionnaireId);
        Question question = new Question(questionnaire, name, description);
        questionFacade.create(question);
    }

    public void addAnswer(Long questionId, String name) {
        Question question = questionFacade.find(questionId);
        Answer answer = new Answer(question, name);
        answerFacade.create(answer);
    }

    public List<Question> getAllQuestions() {
        return questionFacade.findAll();
    }
}
