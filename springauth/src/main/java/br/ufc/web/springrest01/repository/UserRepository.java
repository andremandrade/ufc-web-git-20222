package br.ufc.web.springrest01.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.ufc.web.springrest01.model.UserAccount;

public interface UserRepository extends CrudRepository<UserAccount, Integer>{

    Optional<UserAccount> findUserByUsername(String username);

}
