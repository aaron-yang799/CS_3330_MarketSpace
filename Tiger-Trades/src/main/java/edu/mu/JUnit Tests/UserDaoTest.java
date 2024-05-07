import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;

    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userDao = new UserDao();
        userDao.setConnection(mockConnection);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);  // Simulate at least one result in the result set
    }

    @Test
    public void testAddUser() throws SQLException {
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");
        user.setEmail("test@example.com");

        assertTrue(userDao.addUser(user));
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testGetUserByUsername() throws SQLException {
        when(mockResultSet.getString("username")).thenReturn("testUser");
        when(mockResultSet.getString("password")).thenReturn("testPassword");
        when(mockResultSet.getString("email")).thenReturn("test@example.com");

        User resultUser = userDao.getUserByUsername("testUser");

        assertNotNull(resultUser);
        assertEquals("testUser", resultUser.getUsername());
        assertEquals("testPassword", resultUser.getPassword());
        assertEquals("test@example.com", resultUser.getEmail());
    }

    @Test
    public void testUpdateUser() throws SQLException {
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        User user = new User();
        user.setUsername("updatedUser");
        user.setPassword("updatedPassword");
        user.setEmail("updated@example.com");

        assertTrue(userDao.updateUser(user));
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testDeleteUser() throws SQLException {
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        assertTrue(userDao.deleteUser("testUser"));
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }
}
