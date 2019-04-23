package com.bespin.bcustomer.dao;

import com.bespin.bcustomer.entity.BcustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BcustomerRepository extends JpaRepository<BcustomerEntity,Long> {

}