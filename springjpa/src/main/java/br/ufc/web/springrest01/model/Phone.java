package br.ufc.web.springrest01.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Phone {
   
    @Enumerated(EnumType.STRING)
    private PhoneType type;
    @Column(length = 2)
    private String areaCode;
    @Column(length = 9)
    private String phoneNumber;

}
