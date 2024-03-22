package co.edu.unbosque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpleadoController {

    @GetMapping ("/")
    public ModelAndView index(){
        System.out.println("11036576");
        return new ModelAndView("Proyecto");
    }
    @GetMapping ("/ProyectoForm")
    public ModelAndView proyectosForm(){
         System.out.println("118332023");
        return new ModelAndView("ProyectoForm");
    }
}
