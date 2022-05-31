package com.bridgelabz.springaddressbookapp.service;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapp.exception.AddressBookCustomException;
import com.bridgelabz.springaddressbookapp.model.AddressBookData;
import com.bridgelabz.springaddressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }
    @Override
    public AddressBookData getAddressBookDataById(int id) {
        return addressBookRepository.findById(id)
                .orElseThrow(() ->
                        new AddressBookCustomException("AddressBook with this id " + id + " doest not exists!"));
    }
    @Override
    public List<AddressBookData> getAddressBookByCity(String city) {
        return addressBookRepository.findAddressBookByCity(city);
    }
    @Override
    public List<AddressBookData> sortAddressBookByCity() {
        return addressBookRepository.sortByCity();
    }
    @Override
    public List<AddressBookData> getAddressBookByState(String state) {
        return addressBookRepository.findAddressBookByState(state);
    }
    @Override
    public List<AddressBookData> sortAddressBookByState() {
        return addressBookRepository.sortByState();
    }
    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        log.debug("AddressBook Data:" + addressBookData.toString());
        return addressBookRepository.save(addressBookData);
    }
    @Override
    public AddressBookData updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(id);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }
    @Override
    public void deleteAddressBookData(int id) {
        AddressBookData addressBookData = this.getAddressBookDataById(id);
        addressBookRepository.delete(addressBookData);
    }
}

