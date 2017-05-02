import engine.database.DatabaseAdapter;
import engine.state.Settings;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class StateManagerTest {

    @Test
    public void testDatabaseSetGet() {
        DatabaseAdapter adpt = new DatabaseAdapter("state_manager_test.sqlite");
        Settings settings = new Settings(adpt, 600, 800, 0, true);
        settings.save();

        Settings settings2 = new Settings(adpt, true);
        assertEquals(600, settings2.getResolutionX());
        assertEquals(800, settings2.getResolutionY());
        assertEquals(0, settings2.getVolume());
        assertEquals(true, settings2.getVSync());
    }


    @AfterClass
    public static void clean() {
        File sql = new File("state_manager_test.sqlite");
        sql.delete();
    }

}
