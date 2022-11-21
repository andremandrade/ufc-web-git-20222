package br.ufc.web.springrest01.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private UserAccount owner;
    @Column(length = 300)
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public UserAccount getOwner() {
        return owner;
    }
    public void setOwner(UserAccount owner) {
        this.owner = owner;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    
}
