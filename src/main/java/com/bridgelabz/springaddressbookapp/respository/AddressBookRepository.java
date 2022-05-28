package com.bridgelabz.springaddressbookapp.respository;

import com.bridgelabz.springaddressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {
}
