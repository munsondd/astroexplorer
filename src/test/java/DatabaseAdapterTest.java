import engine.database.DatabaseAdapter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseAdapterTest {

    @Test
    public void testDatabaseSetGet() {
        DatabaseAdapter adpt = new DatabaseAdapter("test.sqlite");
        adpt.set(0, "{}");
        assertEquals("{}", adpt.get(0));
    }

}
