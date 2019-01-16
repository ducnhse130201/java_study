package staticpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "static";
    }

    @RequestMapping(value = "/staticpage", method = RequestMethod.POST)
    public String redirect(){
        return "redirect:/pages/final.html";
    }

}
