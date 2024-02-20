package com.bankproject.bank.repository.services;

import com.bankproject.bank.entity.services.FixedTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedTermRepository extends JpaRepository<FixedTerm, Long> {
}
