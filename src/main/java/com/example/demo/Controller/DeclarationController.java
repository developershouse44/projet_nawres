package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Declarationpanne;
import com.example.demo.Models.Panne;
import com.example.demo.Models.Solution;
import com.example.demo.Repository.DeclarationpanneRepository;
import com.example.demo.Repository.PanneRepository;
import com.example.demo.Repository.SolutionRepository;

@RestController
@RequestMapping("/declarations")
@CrossOrigin("*")
public class DeclarationController {
	
	

	    @Autowired
	    private DeclarationpanneRepository declarationRepository;

	    @Autowired
	    private PanneRepository panneRepository;
	    
	    @Autowired
	    private SolutionRepository solutionRepository;

	    // create declaration
	    @PostMapping("/create/{panneId}")
	    public Declarationpanne create(@PathVariable Long panneId) {

	        Panne panne = panneRepository.findById(panneId).get();

	        Declarationpanne d = new Declarationpanne();
	        d.setPanne(panne);
	        d.setSolutionActuelle(1);
	        d.setStatut("EN_COURS");

	        return declarationRepository.save(d);
	    }

	    // tester solution
	    @PostMapping("/{id}/tester")
	    public Declarationpanne tester(@PathVariable Long id, @RequestParam boolean valide) {

	        Declarationpanne d = declarationRepository.findById(id).get();

	        if (valide) {
	            d.setStatut("RESOLU");
	            d.setSolutionFinale(d.getSolutionActuelle());
	        } else {
	            if (d.getSolutionActuelle() < 4) {
	                d.setSolutionActuelle(d.getSolutionActuelle() + 1);
	            } else {
	                d.setStatut("ECHEC");
	            }
	        }

	        return declarationRepository.save(d);
	    }
	    @GetMapping("/{id}/current-solution")
	    public Solution getCurrentSolution(@PathVariable Long id) {

	        Declarationpanne d = declarationRepository.findById(id).get();

	        return solutionRepository.findByPanneIdAndOrdre(
	                d.getPanne().getId(),
	                d.getSolutionActuelle()
	        );
	}
}

