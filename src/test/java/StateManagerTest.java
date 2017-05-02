import engine.database.DatabaseAdapter;
import engine.state.Settings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateManagerTest {

    @Test
    public void testDatabaseSet() {
        DatabaseAdapter adpt = new DatabaseAdapter("test.sqlite");
        Settings settings = new Settings(adpt, 600, 800, 0, true);
        settings.save();
    }

}
