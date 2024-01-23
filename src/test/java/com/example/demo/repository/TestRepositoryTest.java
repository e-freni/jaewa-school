package com.example.demo.repository;

import com.example.demo.DemoApplication;
import com.example.demo.TestDemoApplication;
import com.example.demo.model.TestEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestRepositoryTest {

    @Autowired
    TestRepository testRepository;

    @Test
    void testPippoSave() {
        this.testRepository.deleteAll();
        this.testRepository.save(new TestEntity("pippo"));

        List<TestEntity> all = this.testRepository.findAll();
        assertEquals(1, all.size());
    }

}