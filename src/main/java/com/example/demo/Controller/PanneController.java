package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Panne;
import com.example.demo.Repository.PanneRepository;

@RestController
@RequestMapping("pannes")
@CrossOrigin(origins="*")
public class PanneController {
//def auto
	
    @Autowired
    private PanneRepository panneRepository;
//crete= fonction
    @PostMapping("/createpanne")
    public Panne create(@RequestBody Panne p) {
        return panneRepository.save(p);
    }

    @GetMapping("/getAll")
    public List<Panne> getAll() {
        return panneRepository.findAll();
    }

}
