package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


    @GetMapping("/login")
    public String login(){

        return "login0";

    }



    @GetMapping("/admin")
    public String admin(){

        return "dashboardADMIN";

    }


    @GetMapping("/agent")
    public String agent(){

        return "dashboardagent";

    }
    @GetMapping("/pannes/list")
    public String pannelist(){

        return "pannes/list";

    }
    //listpanne
    @GetMapping("listpanne")
    public String pannelist1(){

        return "listpanne";

    }
    @GetMapping("listpanneagent")
    public String listpanneagent(){

        return "listpanneagent";

    }
    @GetMapping("/pannes/ajoutpanne")
    public String ajoutpanne(){

        return "pannes/ajoutpanne";

    }
    @GetMapping("declaration_panne")
    public String declaration_panne(){
        return "declaration_panne";
    }
    @GetMapping("solution")
    public String solution(){
        return "solution";
    }
    @GetMapping("listcategorie")
    public String listcategorie(){
        return "listcategorie";
    }



    @GetMapping("/agenttechnique")
    public String technique(){

        return "agenttechnique";

    }
    @GetMapping("/ajouterpannes")
    public String add(){

        return "Admin";

    }

}