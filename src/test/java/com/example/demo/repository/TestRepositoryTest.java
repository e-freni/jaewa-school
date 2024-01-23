package com.example.demo.repository;

import com.example.demo.DemoApplication;
import com.example.demo.TestDemoApplication;
import com.example.demo.model.TestEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = TestRepositoryTest.Initializer.class)
class TestRepositoryTest {

    @Container
    public static MySQLContainer mySQLContainer = new MySQLContainer<>("mysql:5.7.34")
            .withDatabaseName("testdb")
            .withUsername("root")
            .withPassword("root");
    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + mySQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + mySQLContainer.getUsername(),
                    "spring.datasource.password=" + mySQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Autowired
    TestRepository testRepository;

    @Test
    void testPippoSave() {
        this.testRepository.save(new TestEntity("pippo"));

        List<TestEntity> all = this.testRepository.findAll();
        assertEquals(1, all.size());
    }

}