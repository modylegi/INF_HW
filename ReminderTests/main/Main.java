package INF_HW.ReminderTests.main;

import INF_HW.ReminderTests.main.exceptions.NotePersistenceException;
import INF_HW.ReminderTests.main.model.Note;
import INF_HW.ReminderTests.main.repository.NoteRepository;
import INF_HW.ReminderTests.main.repository.impl.NoteRepositorySerializableImpl;

import java.time.Instant;

public class Main {
    // Добавлять заметки на определенное время
    // Отмечать заметки как выполнено
    // Удалять заметки
    // Получать список всех заметок на день
    // Получать список всех выполненных заметок на день
    public static void main(String[] args) {
        try {
            NoteRepository repository = new NoteRepositorySerializableImpl("C:\\Users\\79174\\SecondSem\\src\\Reminder\\" +
                    "database\\notes_database");
            repository.save(new Note("Test1", Instant.now(), false));
            System.out.println(repository.getUndoneByDate(Instant.now()).size());
        } catch (NotePersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
