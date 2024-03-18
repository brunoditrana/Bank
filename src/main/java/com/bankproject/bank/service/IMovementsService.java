package com.bankproject.bank.service;

import com.bankproject.bank.dto.MovementsDTO;

public interface IMovementsService {

    MovementsDTO findById(Long idMovements);
}
