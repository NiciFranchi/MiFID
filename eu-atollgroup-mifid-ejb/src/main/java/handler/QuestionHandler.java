package handler;

import dal.QuestionFacade;
import dal.QuestionnaireFacade;
import entity.Question;
import entity.Questionnaire;
import handlerinterface.QuestionHandlerLocal;

import javax.ejb.EJB;

/**
 * Created by abator on 3/15/2016.
 */
public class QuestionHandler implements QuestionHandlerLocal {
    @EJB
    QuestionFacade questionFacade;

    @EJB
    QuestionnaireFacade questionnaireFacade;

    @Override
    public void addQuestion(Long questionnaireId, String name, String description) {
        Questionnaire questionnaire = questionnaireFacade.find(questionnaireId);
        Question question = new Question(questionnaire, name, description);
        questionFacade.create(question);
    }
}