package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.ServicesAdapter;
import com.bankproject.bank.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesConnector implements ServicesAdapter {

    @Autowired
    private ServicesRepository servicesRepository;

}
