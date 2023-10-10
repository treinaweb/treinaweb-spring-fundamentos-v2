package br.com.treinaweb.springexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/teste")
    public String action(ModelMap model) {
        model.addAttribute("nome", "TreinaWeb");
        return "teste";
    }
    
}
