package testDB;

import databaseConnect.JDBCConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestsSetups {
    private static final Logger log = LogManager.getLogger(TestsSetups.class);

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        log.info("------Started test: " + testInfo.getDisplayName() + "-----");
        Assertions.assertNotNull(JDBCConnection.connectToDB(), "Database connection should not be null");
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        JDBCConnection.closeConnection();
        log.info("------Finished test: " + testInfo.getDisplayName() + "-----");
    }
}