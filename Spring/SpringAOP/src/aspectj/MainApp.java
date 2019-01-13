package aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("aspectj/Beans.xml");

        Student student = (Student) context.getBean("student");
        student.getName();
        student.getAge();

        try {
            student.printThrowException();
        }catch (IllegalArgumentException e){
            System.out.println("raise an Exception." + e.toString());
        }

    }

}
