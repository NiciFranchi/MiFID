package dal;

import entity.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by u95599 on 2016.03.08.
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question>{

    @PersistenceContext
    private EntityManager em;

    public QuestionFacade() {
        super(Question.class);
    }

    @Override
    protected EntityManager em() {
        return em;
    }
}
