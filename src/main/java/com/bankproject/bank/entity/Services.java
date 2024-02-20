package com.bankproject.bank.entity;


import com.bankproject.bank.entity.services.Deposits;
import com.bankproject.bank.entity.services.Extractions;
import com.bankproject.bank.entity.services.FixedTerm;
import com.bankproject.bank.entity.services.Loan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Services {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_services")
    private Long idServices;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "services")
    private List<AccountService> accountServices;

    @OneToOne
    @JoinColumn(name = "id_loan")
    private Loan loan;

    @OneToOne
    @JoinColumn(name = "id_fixed_term")
    private FixedTerm fixedTerm;

    @OneToOne
    @JoinColumn(name = "id_extractions")
    private Extractions extractions;

    @OneToOne
    @JoinColumn(name = "id_deposits")
    private Deposits deposits;
}
