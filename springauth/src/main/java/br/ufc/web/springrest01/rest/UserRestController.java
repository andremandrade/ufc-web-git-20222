package br.ufc.web.springrest01.rest;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/me")
    Principal getMet(Principal me){
        return me;
    }

    @GetMapping
    Iterable<UserAccount> getUsers(@RequestParam Map<String, String> query){
        Iterable<UserAccount> findAll = userRepository.findAll();
        return findAll;
    }

    @GetMapping("/{id}")
    UserAccount getUser(@PathVariable int id){
        Optional<UserAccount> result =  userRepository.findById(id);
        return !result.isPresent() ? null : result.get();
    }
   
    @PostMapping
    UserDTO addUser(@RequestBody UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserAccount savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getUsername(), savedUser.getFullname());
    }

}