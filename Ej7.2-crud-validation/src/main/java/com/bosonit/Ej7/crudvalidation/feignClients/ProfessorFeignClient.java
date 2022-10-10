package com.bosonit.Ej7.crudvalidation.feignClients;

import com.bosonit.Ej7.crudvalidation.professor.infraestructure.controller.Output.ProfessorOutputFullDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="professor-service", url="http://localhost:8081")
public interface ProfessorFeignClient {

    @GetMapping(value = "/profesor/{id}")
    ProfessorOutputFullDto getProfessor(@PathVariable String id);

}
