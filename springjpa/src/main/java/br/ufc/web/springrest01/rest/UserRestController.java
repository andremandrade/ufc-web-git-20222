package br.ufc.web.springrest01.rest;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.springrest01.model.UserAccount;
import br.ufc.web.springrest01.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    UserRepository userRepository;
   
    // @GetMapping
    // Iterable<UserAccount> getUsers(){
    //     return userRepository.findAll();
    // }

    @GetMapping
    Iterable<UserAccount> serachUsers(@RequestParam Map<String, String> query){
        String q = query.get("q");
        System.out.println(q);
        return userRepository.findByNameEndsWith(q);
    }

    @GetMapping("/{id}")
    UserAccount getUser(@PathVariable int id){
        Optional<UserAccount> result =  userRepository.findById(id);
        return !result.isPresent() ? null : result.get();
    }
   
    @PostMapping
    UserAccount addUser(@RequestBody UserAccount user) {
        return userRepository.save(user);
    }
}
