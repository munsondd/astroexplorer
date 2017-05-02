import engine.database.DatabaseAdapter;
import engine.state.Settings;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class StateManagerTest {

    private static final String DB_PATH = "state_manager_test.sqlite";
    private static final boolean DEBUG = false;

    @Test
    public void testDatabaseSetGet() {
        int x = 600;
        int y = 800;
        int vol = 0;
        boolean vsync = true;

        DatabaseAdapter adpt = new DatabaseAdapter(DB_PATH);
        Settings settings = new Settings(adpt, x, y, vol, vsync);
        settings.save();

        Settings settings2 = new Settings(adpt, true);
        assertEquals(x, settings2.getResolutionX());
        assertEquals(y, settings2.getResolutionY());
        assertEquals(vol, settings2.getVolume());
        assertEquals(vsync, settings2.getVSync());
    }

    @AfterClass
    public static void clean() {
        File sql = new File(DB_PATH);
        if (!DEBUG) sql.delete();
    }

}
