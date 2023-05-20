package com.ravilyahya.lombokandslf4j.controller;

import com.ravilyahya.lombokandslf4j.dto.CustomerDto;
import com.ravilyahya.lombokandslf4j.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerDto save(@RequestBody CustomerDto customer){
        return customerService.save(customer);
    }

    @GetMapping
    public List<CustomerDto> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDto getById(@PathVariable Long id){
        return customerService.findById(id);
    }
}
