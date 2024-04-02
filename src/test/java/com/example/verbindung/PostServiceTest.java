package com.example.verbindung;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    public void testFindAllTransformed() {
        // Vorbereitung: Mock-Daten erstellen
        PostEntity postEntity = new PostEntity();
        postEntity.setExecutionTime(Timestamp.valueOf("01.01.2024 12:00"));


        when(postRepository.findAll()).thenReturn(Arrays.asList(postEntity));

        // Test ausführen
        List<PostEntity> result = postService.findAllTransformed();

        // Verifizierung
        assertNotNull(result);
        assertFalse(result.isEmpty());
        PostEntity resultEntity = result.get(0);
        assertEquals("2024-01-01", resultEntity.getDatum()); //richtige Zahlem müssen wir aus der Tabelle zum Testen nehmen.
        assertEquals("12:00", resultEntity.getZeit()); //richtige Zahlem müssen wir aus der Tabelle zum Testen nehmen.

        verify(postRepository, times(1)).findAll();
    }
}
