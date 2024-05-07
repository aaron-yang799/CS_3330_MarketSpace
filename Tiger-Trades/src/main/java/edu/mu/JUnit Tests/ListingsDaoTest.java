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

public class ListingsDaoTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;

    private ListingsDao listingsDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        listingsDao = new ListingsDao();
        listingsDao.setConnection(mockConnection);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);  // Simulate at least one result in the result set
    }

    @Test
    public void testAddListing() throws SQLException {
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        Listing listing = new Listing();
        listing.setTitle("New Listing");
        listing.setDescription("Description of new listing");
        listing.setPrice(99.99);

        assertTrue(listingsDao.addListing(listing));
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testGetListingById() throws SQLException {
        when(mockResultSet.getInt("id")).thenReturn(101);
        when(mockResultSet.getString("title")).thenReturn("Existing Listing");
        when(mockResultSet.getDouble("price")).thenReturn(150.00);

        Listing listing = listingsDao.getListingById(101);

        assertNotNull(listing);
        assertEquals(101, listing.getId());
        assertEquals("Existing Listing", listing.getTitle());
        assertEquals(150.00, listing.getPrice(), 0.001);
    }

    @Test
    public void testUpdateListing() throws SQLException {
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        Listing listing = new Listing();
        listing.setId(101);
        listing.setTitle("Updated Title");
        listing.setDescription("Updated
