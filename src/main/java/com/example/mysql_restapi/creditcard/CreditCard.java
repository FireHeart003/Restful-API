package com.example.mysql_restapi.creditcard;

import jakarta.persistence.*;

import java.time.YearMonth;
import java.util.List;


@Entity
@Table
public class CreditCard {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ccnum;
    private String fName;
    private String lName;
    private String pin;
    private String expireMonth;

    private String expireYear;



    public CreditCard(){}

    public CreditCard(Long id, String ccnum, String fName, String lName, String pin, String expireMonth, String expireYear) {
        this.id = id;
        this.ccnum = ccnum;
        this.fName = fName;
        this.lName = lName;
        this.pin = pin;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCcnum() {
        return ccnum;
    }

    public void setCcnum(String ccnum) {
        this.ccnum = ccnum;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireMonth = expireYear;
    }
}
