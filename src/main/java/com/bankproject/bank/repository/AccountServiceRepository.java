package com.bankproject.bank.repository;

import com.bankproject.bank.entity.AccountService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountServiceRepository extends JpaRepository<AccountService, Long> {
}
