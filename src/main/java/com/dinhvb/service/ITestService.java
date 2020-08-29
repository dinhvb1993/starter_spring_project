package com.dinhvb.service;

import com.dinhvb.dto.TestDTO;
import com.dinhvb.entity.TestEntity;

import java.util.List;

public interface ITestService {
    TestDTO save(TestDTO testDTO);
    TestDTO update(TestDTO testDTO);
    List<TestDTO> findAll();
    TestDTO findOneById(Integer id);
}
