package dal;

import entity.Answer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by u95599 on 2016.03.08.
 */
@Stateless
public class AnswerFacade extends AbstractFacade<Answer>{

    @PersistenceContext
    private EntityManager em;

    public AnswerFacade() {
        super(Answer.class);
    }

    @Override
    protected EntityManager em() {
        return em;
    }
}