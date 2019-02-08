package com.satou.webAvancee.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet( "/session" )
public class SessionTest extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String SESSION_JSP      = "/WEB-INF/Session.jsp";
    private static final String PSEUDO_BAND      = "pseudoh";
    private static final String PWD_BAND         = "pwdh";
    private static final String LOGIN_BOOL       = "login";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( SESSION_JSP ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String pseudo = request.getParameter( PSEUDO_BAND );
        request.setAttribute( "pseudo", pseudo );
        String password = request.getParameter( PWD_BAND );
        HttpSession session = request.getSession();
        if ( check( pseudo, password ) ) {
            System.out.println( pseudo + "-" + password + " true" );
            request.setAttribute( LOGIN_BOOL, true );
        } else {
            System.out.println( pseudo + "-" + password + " false" );
            request.setAttribute( LOGIN_BOOL, false );

        }
        doGet( request, response );
    }

    public boolean check( String p, String l ) {
        if ( p == "test" ) {
            if ( l == "1234" ) {
                return true;
            }
        }
        return true;
    }

}
