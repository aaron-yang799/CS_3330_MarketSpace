import static org.junit.Assert.*;
import org.junit.Test;

import edu.mu.Listing;
import edu.mu.User;

public class Model_Tests {
	@Test
    public void testUserModel() {
        User user = new User();

        // Set values
        user.setId(1);
        user.setUsername("JohnDoe");
        user.setPassword("password123");
        user.setEmail("john.doe@example.com");

        // Test getters
        assertEquals(1, user.getId());
        assertEquals("JohnDoe", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    // Test class for Listing model
    @Test
    public void testListingModel() {
        Listing listing = new Listing();

        // Set values
        listing.setId(101);
        listing.setTitle("Vintage Lamp");
        listing.setDescription("A beautiful vintage lamp from the 1920s.");
        listing.setPrice(150.00);
        listing.setUserId(1);

        // Test getters
        assertEquals(101, listing.getId());
        assertEquals("Vintage Lamp", listing.getTitle());
        assertEquals("A beautiful vintage lamp from the 1920s.", listing.getDescription());
        assertEquals(150.00, listing.getPrice(), 0.001);
        assertEquals(1, listing.getUserId());
    }
}
