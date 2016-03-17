package restservice;


import handlerinterface.QuestionnaireHandlerLocal;
import lookup.EJBLookup;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by abator on 3/12/2016.
 */



@Path("/myhello")
public class MyHelloWorldService {

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("param") String msg) {

        //Questionnaire questionnaire = new Questionnaire("kerdoiv", "en", "te", new Date());
        String output = "Jersey questionnaire say : " + msg;
//        QuestionnaireHandlerLocal handlerBean = null;
//        try {
//            handlerBean = (QuestionnaireHandlerLocal) new InitialContext().lookup("java:app/eu-atollgroup-mifid-ejb-1.0-SNAPSHOT/HandlerBean");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }

        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();

        //handlerBean.addQuestion(new Long(100), msg, "Valami");

        return Response.status(200).entity(output).build();
        //return questionnaire;
    }

}
