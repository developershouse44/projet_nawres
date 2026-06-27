package com.example.demo.Controller;

import com.example.demo.Models.Categorie;
import com.example.demo.Models.Panne;
import com.example.demo.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@CrossOrigin(origins="*")
public class CategorieController {
    @Autowired
    private CategorieRepository categoRepository;
    //crete= fonction
    @PostMapping("/createcategorie")
    public Categorie createcateg(@RequestBody Categorie c) {
        return categoRepository.save(c);
    }
    @GetMapping("/{id}")
    public Categorie findById(@PathVariable Long id){

        return categoRepository.findById(id)
                .orElse(null);
    }
    @PutMapping("/{id}")
    public Categorie update(@PathVariable Long id,
                            @RequestBody Categorie categorie){



        Categorie old = categoRepository.findById(id)
                        .orElse(null);

        if(old == null){
            return null;
        }
        old.setNom(categorie.getNom());
        old.setLibelle(categorie.getLibelle());


        return categoRepository.save(old);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){


        categoRepository.deleteById(id);


        return "deleted successfully";
    }

    @GetMapping("/getAll")
    public List<Categorie> getAll() {
        return categoRepository.findAll();
    }
}
