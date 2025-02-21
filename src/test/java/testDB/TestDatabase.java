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
        String expectedSurname = "Иванов";
        String actualSurname;
        actualSurname = requireNonNull(rs).getString("surname");
        assertEquals(expectedSurname, actualSurname, "Actual name is '" + actualSurname + "', Excpected - '" + expectedSurname + "'.");
    }
    @Test
    @Order(2)
    @DisplayName("Отправка INSERT запроса")
    public void testInsertRequest() throws SQLException {
        String query = "INSERT INTO reg_office.citizens (surname, name, middlename, dateofbirth, gender) VALUES ('Leonardo', 'Di Caprio', 'Иванович', '1986-12-25', 'm')";
        JDBCConnection.insertIntoTable(query);

        String selectQuery = "SELECT * FROM reg_office.citizens WHERE citizenid = 21556";
        ResultSet rs = JDBCConnection.selectFromTable(selectQuery);

        assertTrue(rs.next(), "ResultSet should contain at least one row");

        assertAll("Should return inserted data",
                () -> assertEquals("Leonardo", rs.getString("surname")),
                () -> assertEquals("Di Caprio", rs.getString("name")),
                () -> assertEquals("Иванович", rs.getString("middlename")),
                () -> assertEquals("1986-12-25", rs.getString("dateofbirth")),
                () -> assertEquals("m", rs.getString("gender")));

        rs.close();
    }

    @Test
    @Order(3)
    @DisplayName("Отправка простого SELECT запроса. Проверка вставки строки в таблицу")
    public void testSelectRequest_checkName() throws SQLException {
        String query = "SELECT * FROM reg_office.citizens WHERE citizenid='21556'";
        ResultSet rs = JDBCConnection.selectFromTable(query);
        String expectedName = "Сидоров";
        String actualName = requireNonNull(rs).getString("surname");
        assertEquals(expectedName, actualName, "Actual name is '" + actualName + "', Excpected - '" + expectedName + "'.");
    }

    @Test
    @Order(4)
    @DisplayName("Отправка UPDATE запроса")
    public void testUpdateRequest() throws SQLException {
        String query = "UPDATE reg_office.citizens SET surname = 'Петров замена' WHERE citizenid='21558'";
        JDBCConnection.updateInTable(query);

        String selectQuery = "SELECT surname FROM reg_office.citizens WHERE citizenid='21555'";
        ResultSet rs = JDBCConnection.selectFromTable(selectQuery);
        String expectedTown = "Петров замена";
        String actualTown;
        actualTown = requireNonNull(rs).getString("surname");
        assertEquals(expectedTown, actualTown, "Actual town is '" + actualTown + "', Excpected - '" + expectedTown + "'.");
    }
    @Test
    @Order(5)
    @DisplayName("Отправка DELETE запроса")
    public void testDeleteRequest() {
        String query = "DELETE FROM reg_office.citizens WHERE citizenid='21555'";
        JDBCConnection.deleteFromTable(query);
    }
}





