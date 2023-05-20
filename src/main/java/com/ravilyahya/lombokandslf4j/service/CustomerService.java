package com.ravilyahya.lombokandslf4j.service;

import com.ravilyahya.lombokandslf4j.dto.CustomerDto;
import com.ravilyahya.lombokandslf4j.entity.Customer;
import com.ravilyahya.lombokandslf4j.mappers.CustomerMapper;
import com.ravilyahya.lombokandslf4j.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerDto save(CustomerDto customerDto) {
        log.info("CustomerService.save method called with cif= {} and name= {} ", customerDto.getCif(),customerDto.getName());
        return CustomerMapper.INSTANCE.toDto(
                customerRepository.save(
                        CustomerMapper.INSTANCE.toEntity(customerDto)));
    }

    public List<CustomerDto> findAll() {
        log.info("CustomerService.findAll method called");
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDto findById(Long id) {
        log.info("CustomerService.findById method called with id: {}", id);
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isEmpty()) {
            log.error("CustomerService.findById -- No customer found with id: {}", id);
            return null;
        }
        return CustomerMapper.INSTANCE.toDto(optionalCustomer.get());
    }
}
