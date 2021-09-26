package com.yakut.spring.service;

import com.yakut.spring.exception.NoAddressTableException;
import com.yakut.spring.model.Address;
import com.yakut.spring.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Address findAddressById(Long id) throws NoAddressTableException {
        return addressRepository.findById(id).orElseThrow(() -> new NoAddressTableException(id));
    }

    @Override
    public void deleteAll() {
        addressRepository.deleteAll();
    }
}
