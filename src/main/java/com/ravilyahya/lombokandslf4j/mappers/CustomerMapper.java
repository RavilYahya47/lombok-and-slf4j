package com.ravilyahya.lombokandslf4j.mappers;

import com.ravilyahya.lombokandslf4j.dto.CustomerDto;
import com.ravilyahya.lombokandslf4j.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    @Mapping(target = "cif", source = "customer.cif")
    @Mapping(target = "name", source = "customer.name")
    @Mapping(target = "email", source = "customer.email")
    CustomerDto toDto(Customer customer);

    @Mapping(target = "cif", source = "customerDto.cif")
    @Mapping(target = "name", source = "customerDto.name")
    @Mapping(target = "email", source = "customerDto.email")
    Customer toEntity(CustomerDto customerDto);
}
