package com.stage.stage;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaireRepository extends JpaRepository<Formulaire, Integer> {

}

