package br.com.treinaweb.springexample;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // http://localhost:8080/teste5?age=27&skills=python,java,csharp
    // http://localhost:8080/teste5?age=27&skills=python&skills=java&skills=csharp
    @GetMapping("/teste5")
    public String action5(
        @RequestParam(name = "q", required = false, defaultValue = "treinaweb") 
        String busca,
        @RequestParam int age,
        @RequestParam List<String> skills
    ) {
        System.out.println(busca);
        System.out.println(age);
        System.out.println(skills);
        return "teste";
    }

    // http://localhost:8080/produtos/1
    // http://localhost:8080/produtos/2
    // http://localhost:8080/produtos/3
    @GetMapping("/teste6/{id}/{name}")
    public String action6(@PathVariable("id") Long productId) {
        System.out.println(productId);
        return "teste";
    }
    
}
