package br.ufc.web.springrest01.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserGroup {

    @Id
    @GeneratedValue
    private int id;
    @ManyToMany
    private List<UserAccount> members;
    private String name;
    private String description;
    @ElementCollection
    private List<String> tags;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<UserAccount> getMembers() {
        return members;
    }
    public void setMembers(List<UserAccount> members) {
        this.members = members;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
