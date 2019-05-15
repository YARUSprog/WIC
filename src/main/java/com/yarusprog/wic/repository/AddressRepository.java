package com.yarusprog.wic.repository;

import com.yarusprog.wic.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("addressRepository")
public interface AddressRepository extends JpaRepository<AddressModel, Long> {

}
