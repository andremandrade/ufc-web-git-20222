package br.ufc.web.springrest01.repository;

import org.springframework.data.repository.CrudRepository;

import br.ufc.web.springrest01.model.Hero;

public interface HeroRepository extends CrudRepository<Hero, Integer>{

}
