package br.ufc.web.springrest01.rest;

public class UserDTO {

    private int id;
    private String username;
    private String fullname;

    public UserDTO(String username2, String fullname2) {
        this.username = username2;
        this.fullname = fullname2;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    
}
