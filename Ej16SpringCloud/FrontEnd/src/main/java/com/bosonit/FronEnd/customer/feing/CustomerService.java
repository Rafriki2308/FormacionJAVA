package com.bosonit.FronEnd.customer.feing;

import com.bosonit.FronEnd.customer.infrastructure.output.CustomerOutDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-frontend", url = "${my.direction.feing}")
public interface CustomerService {

    @GetMapping("customer/getByIdByFeing/{id}")
    public CustomerOutDto findById(@PathVariable String id);
}
