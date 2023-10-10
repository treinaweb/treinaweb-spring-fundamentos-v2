package br.com.treinaweb.springexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/teste")
    public String action() {
        System.out.println("Olá TreinaWeb");
        return "treinaweb";
    }
    
}
