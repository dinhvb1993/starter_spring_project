package com.dinhvb.converter;

import com.dinhvb.dto.TestDTO;
import com.dinhvb.entity.TestEntity;
import org.springframework.stereotype.Component;

@Component
public class TestConverter {
    public TestEntity toEntity(TestDTO testDTO, TestEntity testEntity) {
        if (testDTO.getId() != null) {
            testEntity.setId(testDTO.getId());
        }
        if (testDTO.getName() != null) {
            testEntity.setName(testDTO.getName());
        }
        if (testDTO.getValue() != null) {
            testEntity.setValue(testDTO.getValue());
        }

        return testEntity;
    }

    public TestDTO toDTO(TestEntity testEntity) {
        return new TestDTO(
                testEntity.getId(),
                testEntity.getName(),
                testEntity.getValue()
        );
    }
}
