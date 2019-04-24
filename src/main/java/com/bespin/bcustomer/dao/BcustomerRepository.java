package com.bespin.bcustomer.dao;

import com.bespin.bcustomer.entity.BcustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Bcostomer DAO
 *
 * @author voidm
 * @date 2019-04-24
 */
public interface BcustomerRepository extends JpaRepository<BcustomerEntity,Long> {

}