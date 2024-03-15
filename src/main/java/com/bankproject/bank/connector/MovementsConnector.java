package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.MovementsAdapter;
import com.bankproject.bank.repository.MovementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementsConnector implements MovementsAdapter {

    @Autowired
    private MovementsRepository movementsRepository;
}
