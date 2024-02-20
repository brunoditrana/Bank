package com.bankproject.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_branch")
    private Long idBranch;

    @Column(name = "branch_code", nullable = false)
    private Integer branchCode;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "opening_date", nullable = false)
    private LocalDate openingDate;

    @Column(name = "number_account", nullable = false)
    private Integer numberAccount;

    @OneToMany(mappedBy = "branch")
    private List<Account> accounts;

}
