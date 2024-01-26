package net.openwebinars.springboot.restjwt.Note;

import net.openwebinars.springboot.restjwt.SpringSecurityTestWebConfig;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT, classes =
        {SpringSecurityTestWebConfig.class})
@AutoConfigureMockMvc
public class NoteControllerTest {
}
