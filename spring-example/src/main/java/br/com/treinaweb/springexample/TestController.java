package br.com.treinaweb.springexample;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/teste3")
    public String action3(Model model) {
        model.addAttribute("client", new Client("Cleyson", 27));
        return "form";
    }

    @PostMapping("/teste3")
    public String action4(Client client) {
        System.out.println(client);
        return "form";
    }
    
}
