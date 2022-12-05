package br.ufc.web.springrest01.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.springrest01.model.Hero;
import br.ufc.web.springrest01.repository.HeroRepository;

@RestController
@RequestMapping("/api/hero")
public class HeroRestController {

    @Autowired
    HeroRepository repository;
   
    @GetMapping
    Iterable<Hero> getHeros(){
        return repository.findAll();
    }


    @GetMapping("/{id}")
    Hero getUser(@PathVariable int id){
        Optional<Hero> result =  repository.findById(id);
        return !result.isPresent() ? null : result.get();
    }
   
}
