package net.openwebinars.springboot.restjwt.Note;

import net.openwebinars.springboot.restjwt.note.repo.NoteRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Testcontainers
@Sql(value = {"classpath:import-test.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class NoteRepositoryTest {
    @Autowired
    NoteRepository repository;
    @Container
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer(DockerImageName.parse("postgres:16.0"))
            .withUsername("petclinic")
            .withPassword("petclinic")
            .withDatabaseName("postgres-petclinic");

    @ParameterizedTest
    @CsvSource({"4861a891-39a5-4d12-a17b-a789fbd77c19", "47264aaa-ae4e-4cf8-8aa9-0c50aebf8692"})
    void findByAuthor(String name){
        if(Objects.equals(name, "4861a891-39a5-4d12-a17b-a789fbd77c19")) {
            assertEquals(5, repository.findByAuthor(name).size());
            assertEquals("Hola Mundo", repository.findByAuthor(name).get(0).getTitle());
        }
        else
            assertEquals(0, repository.findByAuthor(name).size());
    }
}
