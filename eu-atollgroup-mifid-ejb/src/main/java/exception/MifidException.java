package exception;

/**
 * Created by u95599 on 2016.03.08.
 */
public class MifidException extends Exception {
    private static final long serialVersionUID = 1L;

    public enum ErrorCode {
        GENERAL("GENERAL_ERROR"),
        BUSINESS("BUSINESS_ERROR"),
        INTERNAL_ERROR("INTERNAL_ERROR"),
        NO_RESULT("NO_RESULT"),
        INVALID_QUESTIONNAIRE("INVALID_QUESTIONNAIRE"),



        WS_RQ_NULL("WEBSERVICE_REQUEST_NULL"),
        WS_RQ_EMCHEADER_NULL("WEBSERVICE_REQUEST_EMCHEADER_NULL"),
        WS_RQ_BODY_NULL("WEBSERVICE_REQUEST_BODY_NULL"),
        WS_NO_RESULT("WEBSERVICE_NO_RESULT"),
        WS_INVALID_PARAMETER("WEBSERVICE_INVALID_PARAMETER"),
        WS_MISSING_PARAMETER("WEBSERVICE_MISSING_PARAMETER"),
        WS_PROPERTY_NULL("WEBSERVICE_PROPERTY_NULL"),
        VALIDATOR_ERROR("VALIDATOR_ERROR"),
        VALIDATION_ERROR("VALIDATION_ERROR");

        private String code;

        private ErrorCode(String s) {
            code = s;
        }

        public String getCode() {
            return code;
        }
    }


    private ErrorCode errorCode = ErrorCode.GENERAL;
    private String reasonMessage = null;

    public MifidException(Exception e) {
        super(e);
    }

    public MifidException(String msg, Exception e) {
        super(e);
        this.reasonMessage = msg;
    }

    public MifidException(Exception e, ErrorCode errorCode, String reasonMessage) {
        super(e);
        this.errorCode = errorCode;
        this.reasonMessage = reasonMessage;
    }

    public MifidException(ErrorCode errorCode, String reasonMessage) {
        super();
        this.errorCode = errorCode;
        this.reasonMessage = reasonMessage;
    }

    public MifidException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public String getReasonMessage() {
        return reasonMessage;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

