import engine.database.DatabaseAdapter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseAdapterTest {

    @Test
    public void testLocationDistance() {
        DatabaseAdapter adpt = new DatabaseAdapter("test.sqlite");
        adpt.set(0, "{}");
    }

}
