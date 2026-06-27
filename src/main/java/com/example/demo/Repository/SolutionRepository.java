
package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Long>{

	Solution findByPanneIdAndOrdre(Long id, int solutionActuelle);

	List<Solution> findByPanneIdOrderByOrdreAsc(Long panneId);

}
