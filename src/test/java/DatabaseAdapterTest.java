import engine.database.DatabaseAdapter;
import engine.database.KeySpecifier;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class DatabaseAdapterTest {

    private static final String DB_PATH = "database_adapater_test.sqlite";
    private static final boolean DEBUG = false;

    @Test
    public void testDatabaseSetGet() {
        DatabaseAdapter adpt = new DatabaseAdapter(DB_PATH);
        adpt.set(KeySpecifier.SETTINGS, "{}");
        assertEquals("{}", adpt.get(KeySpecifier.SETTINGS));
    }

    @AfterClass
    public static void clean() {
        File sql = new File(DB_PATH);
        if (!DEBUG) sql.delete();
    }

}
