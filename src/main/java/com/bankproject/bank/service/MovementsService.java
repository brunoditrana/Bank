package com.bankproject.bank.service;

import com.bankproject.bank.adapter.MovementsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementsService implements IMovementsService{


    @Autowired
    private MovementsAdapter movementsAdapter;
}
