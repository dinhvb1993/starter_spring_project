package com.dinhvb.repository;

import com.dinhvb.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestRepository extends JpaRepository<TestEntity, Integer> {
    TestEntity findOneById(Integer id);
}
