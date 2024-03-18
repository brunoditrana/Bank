package com.bankproject.bank.connector;

import com.bankproject.bank.adapter.MovementsAdapter;
import com.bankproject.bank.dto.MovementsDTO;
import com.bankproject.bank.entity.Movements;
import com.bankproject.bank.mapper.MovementsMapper;
import com.bankproject.bank.repository.MovementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementsConnector implements MovementsAdapter {

    @Autowired
    private MovementsRepository movementsRepository;

    @Override
    public MovementsDTO findById(Long idMovements) {

        Movements movements = movementsRepository.findById(idMovements)
                .orElseThrow(); // ESTOOO

        return MovementsMapper.INSTANCE.toDTO(movements);
    }
}
