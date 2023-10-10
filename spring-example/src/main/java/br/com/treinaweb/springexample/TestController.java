package br.com.treinaweb.springexample;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping("/teste")
    public String action(ModelMap model) {
        model.addAttribute("nome", "TreinaWeb");
        return "teste";
    }

    @GetMapping("/teste2")
    public ModelAndView action2() {
        // var modelAndView = new ModelAndView("teste");
        // modelAndView.addObject("nome", "TreinaWeb");
        // return modelAndView;

        return new ModelAndView("teste", Map.of("nome", "TreinaWeb"));
    }
    
}
