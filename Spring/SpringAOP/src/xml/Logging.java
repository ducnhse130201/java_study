package xml;

public class Logging {

    public void beforeAdice(){
        System.out.println("Going to setup student profile");
    }

    public void afterAdvice(){
        System.out.println("Student profile has been setup.");
    }

    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning : " + retVal.toString());
    }

    public void AfterThrowingAdvice(IllegalAccessError ex){
        System.out.println("There has been an exception : " + ex.toString());
    }

}
