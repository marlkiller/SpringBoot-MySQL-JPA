package com.bespin.bcustomer.service;

import com.bespin.bcustomer.dao.BcustomerRepository;
import com.bespin.bcustomer.entity.BcustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author voidm
 * @date 2019-04-23
 */

@Service
public class BcustomerService {

    @Autowired
    private BcustomerRepository bcustomerRepository;


    public void save(BcustomerEntity bcustomerEntity) {
        // FIXME 批量插入
        BcustomerEntity save = bcustomerRepository.save(bcustomerEntity);
    }

    public List<BcustomerEntity> findAll() {
        return bcustomerRepository.findAll();
    }
}