package com.bridgelabz.springaddressbookapp.model;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public @Data class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    private String fName;

    private String lName;

    private String phonenumber;

    private String email;

    private String city;

    private String state;

    private long zipcode;

    public AddressBookData() {

    }

    public AddressBookData(int id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.fName = addressBookDTO.getFName();
        this.lName = addressBookDTO.getLName();
        this.phonenumber = addressBookDTO.getPhonenumber();
        this.email = addressBookDTO.getEmail();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zipcode = addressBookDTO.getZipcode();
    }
   }
