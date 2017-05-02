import engine.database.DatabaseAdapter;
import engine.database.KeySpecifier;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class DatabaseAdapterTest {

    @Test
    public void testDatabaseSetGet() {
        DatabaseAdapter adpt = new DatabaseAdapter("database_adapater_test.sqlite");
        adpt.set(KeySpecifier.SETTINGS, "{}");
        assertEquals("{}", adpt.get(KeySpecifier.SETTINGS));
    }

    @AfterClass
    public static void clean() {
        File sql = new File("database_adapater_test.sqlite");
        sql.delete();
    }

}
