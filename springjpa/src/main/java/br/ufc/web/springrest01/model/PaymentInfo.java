package br.ufc.web.springrest01.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PaymentInfo {

    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private CreditCard creditCard;
    private String cardNumber;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @OneToOne
    private UserAccount user;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public UserAccount getUser() {
        return user;
    }
    public void setUser(UserAccount user) {
        this.user = user;
    }
    
}

