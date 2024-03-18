package com.bankproject.bank.controller;

import com.bankproject.bank.dto.MovementsDTO;
import com.bankproject.bank.dto.response.MovementsResponse;
import com.bankproject.bank.mapper.MovementsMapper;
import com.bankproject.bank.service.IMovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movements")
public class MovementsController {


    @Autowired
    private IMovementsService movementsService;


    @GetMapping("/{idMovements}")
    public ResponseEntity<MovementsResponse> findById(@PathVariable Long idMovements){

        MovementsDTO movementsDTO = movementsService.findById(idMovements);
        return ResponseEntity.ok().body(MovementsMapper.INSTANCE.toResponse(movementsDTO));
    }
}
