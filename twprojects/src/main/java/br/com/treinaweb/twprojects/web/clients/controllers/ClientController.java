package br.com.treinaweb.twprojects.web.clients.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.twprojects.core.repositories.ClientRepository;
import br.com.treinaweb.twprojects.web.clients.dtos.ClientForm;
import br.com.treinaweb.twprojects.web.clients.dtos.ClientViewModel;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    @GetMapping
    public ModelAndView index() {
        var clients = clientRepository.findAll()
            .stream()
            .map(ClientViewModel::of)
            .toList();
        var model = Map.of("clients", clients);
        return new ModelAndView("clients/index", model);
    }

    @GetMapping("/create")
    public ModelAndView create() {
        var model = Map.of("clientForm", new ClientForm());
        return new ModelAndView("clients/create", model);
    }

    @PostMapping("/create")
    public String create(ClientForm clientForm) {
        var client = clientForm.toClient();
        clientRepository.save(client);
        return "redirect:/clients";
    }
    
}
