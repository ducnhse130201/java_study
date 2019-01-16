package exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class StudentController {
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView student(@ModelAttribute("ExceptWeb")Student student){
        return new ModelAndView("students", "command", new Student());
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ExceptionHandler({SpringException.class})
    public String addStudent(@ModelAttribute("ExceptWeb")Student student,
        ModelMap model){
        if(student.getName().length() < 5){
            throw new SpringException("Given name is too short");
        }else{
            model.addAttribute("name", student.getName());
        }

        if(student.getAge() < 10){
            throw new SpringException("Given age is too low");
        }else {
            model.addAttribute("age", student.getAge());
        }

        model.addAttribute("id", student.getId());
        return "result";



    }

}
