package com.bankproject.bank.repository;

import com.bankproject.bank.entity.Movements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementsRepository extends JpaRepository<Movements,Long> {
}
