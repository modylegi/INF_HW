package INF_HW.ReminderTests.test;

import INF_HW.ReminderTests.main.exceptions.NotePersistenceException;
import INF_HW.ReminderTests.main.model.Note;
import INF_HW.ReminderTests.main.repository.NoteRepository;
import INF_HW.ReminderTests.main.repository.impl.NoteRepositoryCsvImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class NoteRepositoryCsvImplTest {
    static NoteRepository repository = new NoteRepositoryCsvImpl("C:\\Users\\user\\Desktop\\JavaProjects\\src\\INF_HW\\ReminderTests\\database\\notes_test.csv");

    @Test
    void checkSave() {
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), false));

        Assertions.assertEquals(2, repository.getAll().size());
        repository.deleteAll();
    }
    @Test
    void checkGetId() {
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test3", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test4", Instant.ofEpochSecond(1648190891), false));

        Assertions.assertEquals("Test2", repository.getById(2).getText());
        repository.deleteAll();
    }
    @Test
    void checkUndonable() {
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), true));
        repository.save(new Note("Test3", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test4", Instant.ofEpochSecond(1648190891), true));

        Assertions.assertEquals(2, repository.getUndoneByDate(Instant.ofEpochSecond(1648190891)).size());

        repository.deleteAll();
    }

    @Test
    void checkRemoveByID() {
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), true));
        repository.save(new Note("Test3", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test4", Instant.ofEpochSecond(1648190891), true));

        repository.delete(2);
        NotePersistenceException thrown = Assertions.assertThrows(NotePersistenceException.class, () -> {
            repository.getById(2);
        });

        Assertions.assertEquals("Note with id 2 not found", thrown.getMessage());
        repository.deleteAll();
    }
}
