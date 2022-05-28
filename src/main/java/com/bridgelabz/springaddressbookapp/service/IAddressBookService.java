package com.bridgelabz.springaddressbookapp.service;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();
    AddressBookData getAddressBookDataById(int id);
    AddressBookData createAddressBookData(AddressBookDTO addressbookDTO);
    AddressBookData updateAddressBookData( int id, AddressBookDTO addressBookDTO);

    void deleteAddressBookData(int id);

}
