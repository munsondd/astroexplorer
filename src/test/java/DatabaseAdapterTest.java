import engine.database.DatabaseAdapter;
import engine.database.KeySpecifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseAdapterTest {

    @Test
    public void testDatabaseSetGet() {
        DatabaseAdapter adpt = new DatabaseAdapter("database_adapater_test.sqlite");
        adpt.set(KeySpecifier.SETTINGS, "{}");
        assertEquals("{}", adpt.get(KeySpecifier.SETTINGS));
    }

}
