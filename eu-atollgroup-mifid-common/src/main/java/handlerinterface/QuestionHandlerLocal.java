package handlerinterface;

import entity.Question;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by abator on 3/15/2016.
 */
@Local
public interface QuestionHandlerLocal {
    void addQuestion(Long questionnaireId, String name, String description);
    List<Question> getQuestions(Long questionnaireId);
}
