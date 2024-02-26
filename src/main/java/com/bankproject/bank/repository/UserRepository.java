package com.bankproject.bank.repository;

import com.bankproject.bank.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Profile,Long> {
}
