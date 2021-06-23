package example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import example.service.CamundaService;

@RestController
@RequestMapping("/process")
public class Controller {

    CamundaService camundaService;

    public Controller(@Autowired CamundaService camundaService) {
        this.camundaService = camundaService;
    }

    @PostMapping("/start/{processName}")
    public String start(@PathVariable String processName) {
        return camundaService.start(processName);
    }
}
