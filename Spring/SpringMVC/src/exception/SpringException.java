package exception;

public class SpringException extends RuntimeException {
    private String exceptionMsg;

    public SpringException(String exceptionMsg){
        setExceptionMsg(exceptionMsg);
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
