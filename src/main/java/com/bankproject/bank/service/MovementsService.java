package com.bankproject.bank.service;

import com.bankproject.bank.adapter.MovementsAdapter;
import com.bankproject.bank.dto.MovementsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementsService implements IMovementsService{


    @Autowired
    private MovementsAdapter movementsAdapter;

    @Override
    public MovementsDTO findById(Long idMovements) {

        return movementsAdapter.findById(idMovements);
    }
}
