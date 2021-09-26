package com.yakut.spring.repository;

import com.yakut.spring.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//todo нахуя оно?
public interface AddressRepository extends JpaRepository<Address, Long> {
}
