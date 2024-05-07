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

public class SignInServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    private SignInServlet servlet;
    private StringWriter responseWriter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        servlet = new SignInServlet();
        responseWriter = new StringWriter();

        when(request.getSession()).thenReturn(session);
        when(response.getWriter()).thenReturn(new PrintWriter(responseWriter));
    }

    @Test
    public void testSignInSuccessful() throws Exception {
        when(request.getParameter("username")).thenReturn("user");
        when(request.getParameter("password")).thenReturn("pass");

        servlet.doPost(request, response);

        verify(session).setAttribute("username", "user");
        assertEquals("Login successful", responseWriter.toString().trim());
    }

    @Test
    public void testSignInFailure() throws Exception {
        when(request.getParameter("username")).thenReturn("user");
        when(request.getParameter("password")).thenReturn("wrongpass");

        servlet.doPost(request, response);

        verify(session, never()).setAttribute(eq("username"), anyString());
        assertEquals("Login failed", responseWriter.toString().trim());
    }
}
