package com.bankproject.bank.controller;


import com.bankproject.bank.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private IServicesService servicesService;
}
