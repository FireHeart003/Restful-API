package com.example.mysql_restapi.creditcard;

import jakarta.persistence.*;


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
    @Column
    private String month;
    @Column
    private String year;



    public CreditCard(){}

    public CreditCard(String ccnum, String fName, String lName, String pin, String expireMonth, String expireYear) {
        this.ccnum = ccnum;
        this.fName = fName;
        this.lName = lName;
        this.pin = pin;
        this.month = expireMonth;
        this.year = expireYear;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String expireMonth) {
        this.month = expireMonth;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String expireYear) {
        this.year = expireYear;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", ccnum='" + ccnum + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", pin='" + pin + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
