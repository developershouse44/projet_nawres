package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.Panne;
import com.example.demo.Models.Solution;
import com.example.demo.Models.User;
import com.example.demo.Repository.PanneRepository;
import com.example.demo.Repository.SolutionRepository;

@RestController
@RequestMapping("solution")
@CrossOrigin("*")
public class SolutionController {

	
	
	@Autowired
	private SolutionRepository solutionRepository;
	@Autowired 
private PanneRepository pannerepo ; 
	
	
	@PostMapping ("/create")
	public Solution create (@RequestBody Solution s) {
		return solutionRepository.save(s);
	}
	@GetMapping ("liste")
		public List<Solution> affichelist(){
			return solutionRepository .findAll();
		}
	//ajouter solution a une panne
	@PostMapping("/ajout/{panne_id}")
	public Solution createsolution (@PathVariable Long panne_id,@RequestBody Solution s) {
		Panne panne =pannerepo.findById(panne_id).get();
		s.setPanne(panne);
		return solutionRepository.save(s);
		
		
	}
	//Get solutions d'une panne
    @GetMapping("/panne/{panneId}")
    public List<Solution> getByPanne(@PathVariable Long panneId) {

        return solutionRepository
                .findByPanneIdOrderByOrdreAsc(panneId);
    }

    //Get solution spécifique par ordre
    @GetMapping("/panne/{panneId}/ordre/{ordre}")
    public Solution getSolutionByOrdre(@PathVariable Long panneId,
                                       @PathVariable int ordre) {

        return solutionRepository
                .findByPanneIdAndOrdre(panneId, ordre);
    }
	@PutMapping("/{id}")
	public Solution update(
			@PathVariable Long id,
			@RequestBody Solution s){

		Solution old=solutionRepository.findById(id).get();

		old.setDescription(s.getDescription());
		old.setOrdre(s.getOrdre());

		return solutionRepository.save(old);
	}



	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id){

		solutionRepository.deleteById(id);

		return "deleted";

	}
		}


