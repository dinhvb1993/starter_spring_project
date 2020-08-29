package com.dinhvb.api;

import com.dinhvb.dto.TestDTO;
import com.dinhvb.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestAPI {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/api-test")
    public List<TestDTO> getTest(){
        return testService.findAll();
    }

    @GetMapping(value = "/api-test/{id}")
    public TestDTO getTest(@PathVariable(value = "id", required = true) Integer id){
        return testService.findOneById(id);
    }

    @PostMapping(value = "/api-test")
    public TestDTO createTest(@RequestBody TestDTO testDTO){
        return testService.save(testDTO);
    }

    @PutMapping(value = "/api-test")
    public TestDTO updateTest(@RequestBody TestDTO testDTO){
        return testService.update(testDTO);
    }
}
