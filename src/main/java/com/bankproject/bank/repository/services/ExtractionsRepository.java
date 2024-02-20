package com.bankproject.bank.repository.services;

import com.bankproject.bank.entity.services.Extractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtractionsRepository extends JpaRepository<Extractions,Long> {
}
