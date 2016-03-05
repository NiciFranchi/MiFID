package dal;

import entity.Questionnaire;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by u95599 on 2016.03.04.
 */
@Stateless
public class QuestionnaireFacade extends AbstractFacade<Questionnaire>{

    @PersistenceContext
    private EntityManager em;

    public QuestionnaireFacade() {
        super(Questionnaire.class);
    }

    @Override
    protected EntityManager em() {
        return em;
    }
}
