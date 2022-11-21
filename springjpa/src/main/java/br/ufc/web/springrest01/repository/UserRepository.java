package br.ufc.web.springrest01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.ufc.web.springrest01.model.UserAccount;

public interface UserRepository extends CrudRepository<UserAccount, Integer>{

    List<UserAccount> findByNameOrEmail(String name, String email);

    @Query("select u from UserAccount u where u.name like %?1")
    List<UserAccount> findByNameEndsWith(String name);
}
