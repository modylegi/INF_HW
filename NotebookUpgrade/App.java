package INF_HW.NotebookUpgrade;

import INF_HW.NotebookUpgrade.data.Db;
import INF_HW.NotebookUpgrade.data.DbException;
import INF_HW.NotebookUpgrade.data.FileDb;
import INF_HW.NotebookUpgrade.utils.*;

import java.nio.file.Paths;
import java.util.Arrays;

public class App extends Application {

    private static final String DB = "C:\\Users\\user\\Desktop\\JavaProjects\\src\\INF_HW\\NotebookUpgrade\\tmp\\db.txt";
    private static final String PUNCH_CARD = "C:\\Users\\user\\Desktop\\JavaProjects\\src\\INF_HW\\NotebookUpgrade\\tmp\\card.txt";

    protected UserInteract terminal;
    protected Db db;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App(args);
    }

    public App(String[] args) {
        super(args);
    }

    @Override
    public void init() {
        try {
            this.terminal = new PunchedCardUserInteract(Paths.get(App.PUNCH_CARD));
            this.db = new FileDb(App.DB);
        } catch (UserInteractException ex) {
            System.out.println("Couldn't start application due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void start() {
        try {
            String command;
            while ((command = terminal.readCommand()) != null) {
                switch (command) {
                    case "readAll":
                        terminal.print(Arrays.toString(db.findAll()));
                        break;
                    case "save":
                        if ((command = terminal.readCommand()) != null) {
                            db.save(command);
                        }
                        break;
                    case "removeAll":
                        db.removeAll();
                        break;
                    case "removeByIndex":
                        db.removeByIndex();
                        break;
                    default:
                        terminal.print("Unknown command");
                }
            }
        } catch (UserInteractReadException ex) {
            System.out.println("Can't read user input due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (UserInteractWriteException ex) {
            System.out.println("Can't print data to user due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (DbException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

}