package dal;

import entity.Questionnaire;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by u95599 on 2016.03.04.
 */
public class QuestionnairreFacade extends AbstractFacade<Questionnaire>{

    @PersistenceContext
    private EntityManager em;

    public QuestionnairreFacade(Class<Questionnaire> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager em() {
        return em;
    }
}
