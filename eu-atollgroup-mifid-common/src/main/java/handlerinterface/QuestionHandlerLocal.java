package handlerinterface;

import javax.ejb.Local;

/**
 * Created by abator on 3/15/2016.
 */
@Local
public interface QuestionHandlerLocal {
    void addQuestion(Long questionnaireId, String name, String description);
}
