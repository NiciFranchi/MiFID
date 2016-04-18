package handlerinterface;

import entity.Questionnaire;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by abator on 3/13/2016.
 */
@Local
public interface QuestionnaireHandlerLocal {
    List<Questionnaire> getQuestionnaires();

    void addQuestionnaire(Questionnaire questionnaire);

    void editQuestionnaire(Questionnaire questionnaire);

    Questionnaire getQuestionnaire(Long id);

    void deleteQuestionnaire(Long id);
}