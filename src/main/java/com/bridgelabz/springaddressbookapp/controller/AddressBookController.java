package com.bridgelabz.springaddressbookapp.controller;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapp.dto.ResponseDTO;
import com.bridgelabz.springaddressbookapp.model.AddressBookData;
import com.bridgelabz.springaddressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * @author sameer
 *AddressBookController class represents the end points
 */
@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
    @Autowired
    private IAddressBookService iAddressBookService;
    //ability to Save the data in repository
    @PostMapping("/create")

    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = iAddressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("created Addressbook data succesfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //ability to gettin Addressbookdata from Database
    @RequestMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        List<AddressBookData> addressBookData = iAddressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call Success", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //With this end poin getting Addressbookdata dased up on Id
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable int id) {
        AddressBookData addressBookData = iAddressBookService.getAddressBookDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get call Success", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //ability to get addressbook data by city
    @GetMapping("/getcity/{city}")
    public ResponseEntity<ResponseDTO> getAddressBookByCity(@PathVariable("city") String city) {
        List<AddressBookData> addressBookList = null;
        addressBookList = iAddressBookService.getAddressBookByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get call search by city is successful!", addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //ability to get addressbook data by using sortbycity
    @GetMapping("/get/sortbycity")
    public ResponseEntity<ResponseDTO> sortByCity() {
        List<AddressBookData> addressBookList = null;
        addressBookList = iAddressBookService.sortAddressBookByCity();
        ResponseDTO responseDTO = new ResponseDTO("Sort by city call is successful! ", addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //ability to get addressbook data by using state
    @GetMapping("/getstate/{state}")
    public ResponseEntity<ResponseDTO> getAddressBookByState(@PathVariable("state") String state) {
        List<AddressBookData> addressBookList = null;
        addressBookList = iAddressBookService.getAddressBookByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get call search by state is successful!", addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //ability to get addressbook data by using sortbystate
    @GetMapping("/get/sortbystate")
    public ResponseEntity<ResponseDTO> sortByState() {
        List<AddressBookData> addressBookList = null;
        addressBookList = iAddressBookService.sortAddressBookByCity();
        ResponseDTO responseDTO = new ResponseDTO("Sort by state call is successful! ", addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //ability to update addressbook data by using particular Id
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = iAddressBookService.updateAddressBookData(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("updated Addressbook data succesfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //ability to delete addressbook data by using particular Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable int id) {
        iAddressBookService.deleteAddressBookData(id);
        ResponseDTO responseDTO = new ResponseDTO("deleted succesfully", id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
