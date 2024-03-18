package com.bankproject.bank.repository;

import com.bankproject.bank.dto.ProfileDTO;
import com.bankproject.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {


    Account findByAccountNumber(Long accountNumber);
}
