package net.openwebinars.springboot.restjwt.Note;


import net.openwebinars.springboot.restjwt.dto.GetNoteDto;
import net.openwebinars.springboot.restjwt.note.model.Note;
import net.openwebinars.springboot.restjwt.note.repo.NoteRepository;
import net.openwebinars.springboot.restjwt.note.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {
    @Mock
    NoteRepository repository;

    @Mock
    GetNoteDto noteDto;


    @InjectMocks
    NoteService service;

    @ParameterizedTest
    @CsvSource({"1", "2", "3"})
    void notesGroupedByTagsDtoList(String author){
        List<Note> toReturn = List.of(Note.builder()
                        .author("1")
                        .tags(List.of("movie", "robots"))
                        .id(1L)
                        .content("Hi i Like This Film")
                        .title("I, Robot")
                        .important(false)
                        .build(),
                Note.builder()
                        .id(2L)
                        .author("1")
                        .tags(List.of("movie", "robots"))
                        .content("Hi i Like This Film")
                        .title("I, Robot")
                        .important(false)
                        .build());
        List<Note> notes = List.of(Note.builder()
                        .author("1")
                        .tags(List.of())
                        .id(1L)
                        .content("Hi i Like This Film")
                        .title("I, Robot")
                        .important(false)
                        .build(),
                Note.builder()
                        .id(2L)
                        .author("1")
                        .tags(List.of())
                        .content("Hi i Like This Film")
                        .title("I, Robot")
                        .important(false)
                        .build());
        if(author.equals("1")) {
            Mockito.when(repository.findByAuthor(author)).thenReturn(List.of());
            assertNull(service.notesGroupedByTagsDtoList(author));
        } else if (author.equals("3")) {
            Mockito.when(repository.findByAuthor(author)).thenReturn(notes);
            assertEquals(0, service.notesGroupedByTagsDtoList(author).size());
        } else {
            Mockito.when(repository.findByAuthor(author)).thenReturn(toReturn);
            assertEquals(2, service.notesGroupedByTagsDtoList(author).size());
        }


    }
}
