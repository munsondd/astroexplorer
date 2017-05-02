import engine.database.DatabaseAdapter;
import engine.database.RowSpecifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseAdapterTest {

    @Test
    public void testDatabaseSetGet() {
        DatabaseAdapter adpt = new DatabaseAdapter("test.sqlite");
        adpt.set(RowSpecifier.SETTINGS, "{}");
        assertEquals("{}", adpt.get(RowSpecifier.SETTINGS));
    }

}
