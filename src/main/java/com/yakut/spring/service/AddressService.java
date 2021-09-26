package com.yakut.spring.service;

import com.yakut.spring.exception.NoAddressTableException;
import com.yakut.spring.exception.NoUserTableException;
import com.yakut.spring.model.Address;
import java.util.List;

public interface AddressService {

    Address save(Address address);

    void deleteAddressById(Long id);

    List<Address> findAllAddress();

    Address findAddressById(Long id) throws NoUserTableException, NoAddressTableException;

    void deleteAll();
}