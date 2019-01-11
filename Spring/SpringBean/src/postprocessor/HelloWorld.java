package postprocessor;

public class HelloWorld {
    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    public void getMessage(){
        System.out.println("Your Message : " + message);
    }

    public void init(){
        System.out.println("Beans is going through init.");
    }

    public void destory(){
        System.out.println("Bean will destory now.");
    }



}
