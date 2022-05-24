package INF_HW.ReminderTests.main.repository;
import INF_HW.ReminderTests.main.model.Note;
import java.time.Instant;
import java.util.List;

public interface NoteRepository {
    void save(Note note);
    List<Note> getAll();
    Note getById(int id);
    void delete(int id);
    void deleteAll();
    List<Note> getByDate(Instant date);
    List<Note> getUndoneByDate(Instant date);
}
