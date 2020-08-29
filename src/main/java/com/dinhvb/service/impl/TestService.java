package com.dinhvb.service.impl;

import com.dinhvb.converter.TestConverter;
import com.dinhvb.dto.TestDTO;
import com.dinhvb.entity.TestEntity;
import com.dinhvb.repository.ITestRepository;
import com.dinhvb.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TestService implements ITestService {

    @Autowired
    private ITestRepository testRepository;

    @Autowired
    private TestConverter testConverter;

    @Override
    public TestDTO save(TestDTO testDTO) {

        TestEntity testEntity =  testRepository.save(testConverter.toEntity(testDTO, new TestEntity()));

        return testConverter.toDTO(testEntity);
    }

    @Override
    public TestDTO update(TestDTO testDTO) {
        TestEntity testEntity = testRepository.findOneById(testDTO.getId());

        return testConverter.toDTO(testRepository.save(  testConverter.toEntity(testDTO, testEntity)  ));
    }

    @Override
    public List<TestDTO> findAll() {
        List<TestDTO> testDTOList = new ArrayList<>();

        for (TestEntity testEntity: testRepository.findAll()){
            testDTOList.add(testConverter.toDTO(testEntity));
        }


        return testDTOList;
    }

    @Override
    public TestDTO findOneById(Integer id) {
        if (testRepository.findOneById(id) != null){
            return testConverter.toDTO(testRepository.findOneById(id));
        }
        return null;
    }
}
