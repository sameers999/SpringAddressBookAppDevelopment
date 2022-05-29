package com.bridgelabz.springaddressbookapp.repository;

import com.bridgelabz.springaddressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {
    @Query(value = "select * from address_book_table where city = :city", nativeQuery = true)
    List<AddressBookData> findAddressBookByCity(String city);
}
