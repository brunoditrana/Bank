package com.bankproject.bank.repository;

import com.bankproject.bank.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {

    Branch findByBranchCode(Integer branchCode);

    Branch findByBranchName(String branchName);


    void deleteByBranchCode(Integer branchCode);
}
