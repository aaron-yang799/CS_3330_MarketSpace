import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

public class SignUpServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    private SignUpServlet servlet;
    private StringWriter responseWriter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servlet = new SignUpServlet();
        responseWriter = new StringWriter();

        when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));
    }

    @Test
    public void testSignUpSuccessful() throws Exception {
        when(request.getParameter("username")).thenReturn("newuser");
        when(request.getParameter("password")).thenReturn("newpass");
        when(request.getParameter("email")).thenReturn("newuser@example.com");

        servlet.doPost(request, response);

        assertEquals("Registration successful", responseWriter.toString().trim());
    }

    @Test
    public void testSignUpFailure() throws Exception {
        // Simulate failure scenario, such as username already exists
        when(request.getParameter("username")).thenReturn("existinguser");

        servlet.doPost(request, response);

        assertEquals("Registration failed", responseWriter.toString().trim());
    }
}
