package com.bankproject.bank.adapter;

import com.bankproject.bank.dto.MovementsDTO;

public interface MovementsAdapter {

    MovementsDTO findById(Long idMovements);
}
