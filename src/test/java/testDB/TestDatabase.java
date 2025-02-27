package testDB;
import databaseConnect.JDBCConnection;
import org.junit.jupiter.api.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Проверка подключения к БД ЗАГС и отправка запросов")
public class TestDatabase extends TestsSetups {
    @Test
    @Order(1)
    @DisplayName("Отправка простого SELECT запроса. Проверка фамилии")
    public void testSelectRequest_checkSurname() throws SQLException {
        String query = "SELECT * FROM reg_office.citizens WHERE citizenid='21558'";
        ResultSet rs = JDBCConnection.selectFromTable(query);
        String expectedSurname = "Петров замена";
        String actualSurname;
        actualSurname = requireNonNull(rs).getString("surname");
        assertEquals(expectedSurname, actualSurname, "Actual name is '" + actualSurname + "', Excpected - '" + expectedSurname + "'.");
    }
    @Test
    @Order(2)
    @DisplayName("Отправка INSERT запроса")
    public void testInsertRequest() throws SQLException {
        String query = "INSERT INTO reg_office.citizens (surname, name, middlename, dateofbirth, gender) VALUES ('Di Caprio', 'Leonardo', 'Иванович', '1986-12-25', 'm')";
        JDBCConnection.insertIntoTable(query);

        String selectQuery = "SELECT * FROM reg_office.citizens WHERE surname='Di Caprio' AND name='Leonardo' AND middlename='Иванович' AND dateofbirth='1986-12-25' AND gender='m'";
        ResultSet rs = JDBCConnection.selectFromTable(selectQuery);

        assertTrue(rs.next(), "ResultSet should contain at least one row");
        String generatedCitizenId = rs.getString("citizenid");
        assertAll("Should return inserted data",
                () -> assertEquals(generatedCitizenId, rs.getString("citizenid")),
                () -> assertEquals("Di Caprio", rs.getString("surname")),
                () -> assertEquals("Leonardo", rs.getString("name")),
                () -> assertEquals("Иванович", rs.getString("middlename")),
                () -> assertEquals("1986-12-25", rs.getString("dateofbirth")),
                () -> assertEquals("m", rs.getString("gender")));
        rs.close();
    }
    @Test
    @Order(3)
    @DisplayName("Отправка простого SELECT запроса. Проверка имени")
    public void testSelectRequest_checkName() throws SQLException {
        String query = "SELECT * FROM reg_office.citizens WHERE name='Leonardo'";
        ResultSet rs = JDBCConnection.selectFromTable(query);
        String expectedName = "Leonardo";
        String actualName = requireNonNull(rs).getString("name");
        assertEquals(expectedName, actualName, "Actual name is '" + actualName + "', Excpected - '" + expectedName + "'.");
    }
    @Test
    @Order(4)
    @DisplayName("Отправка UPDATE запроса")
    public void testUpdateRequest() throws SQLException {
        String query = "UPDATE reg_office.citizens SET surname = 'Петров замена' WHERE citizenid='47469'";
        JDBCConnection.updateInTable(query);

        String selectQuery = "SELECT surname FROM reg_office.citizens WHERE citizenid='47469'";
        ResultSet rs = JDBCConnection.selectFromTable(selectQuery);
        String expectedSurname = "Петров замена";
        String actualSurname = requireNonNull(rs).getString("surname");
        assertEquals(expectedSurname, actualSurname, "Actual town is '" + actualSurname + "', Excpected - '" + expectedSurname + "'.");
    }
    @Test
    @Order(5)
    @DisplayName("Отправка DELETE запроса")
    public void testDeleteRequest() throws SQLException {
        String selectQuery = "SELECT * FROM reg_office.citizens WHERE surname='Di Caprio'";
        ResultSet rs = JDBCConnection.selectFromTable(selectQuery);
        assertTrue(rs.next(), "No record found for surname 'Di Caprio'");

        String expectedSurname = "Di Caprio";
        String actualSurname = rs.getString("surname");
        assertEquals(expectedSurname, actualSurname, "Actual name is '" + actualSurname + "', Expected - '" + expectedSurname + "'.");

        String deleteQuery = "DELETE FROM reg_office.citizens WHERE surname ='Di Caprio'";
        JDBCConnection.deleteFromTable(deleteQuery);

        ResultSet rsAfterDelete = JDBCConnection.selectFromTable(selectQuery);
        assertFalse(rsAfterDelete.next(), "Record with surname 'Di Caprio' should have been deleted.");
    }
}





