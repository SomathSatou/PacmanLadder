package com.satou.webAvancee.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.satou.webAvancee.model.Utilisateur;

/**
 * Servlet implementation class FisrtServlets
 */
@WebServlet( "/SoyLuna" )
public class FirstServlets extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String INDEX_JSP        = "/WEB-INF/index.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        Utilisateur test = new Utilisateur();
        test.setNom( "Cailloux" );
        test.setPrenom( "Pierre" );
        String auteur = request.getParameter( "auteur" );
        request.setAttribute( "test", auteur );

        request.setAttribute( "user", test );
        this.getServletContext().getRequestDispatcher( INDEX_JSP ).forward( request, response );
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
