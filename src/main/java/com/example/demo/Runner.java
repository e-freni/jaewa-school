package com.example.demo;

import com.example.demo.model.TestEntity;
import com.example.demo.repository.TestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    public TestRepository testRepository;

    public Runner(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        testRepository.save(new TestEntity("pippo"));
    }
}
