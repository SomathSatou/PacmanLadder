package com.satou.webAvancee.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TEST
 */
@WebServlet( "/inscription" )
public class Inscription extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String TEST_JSP         = "/WEB-INF/inscription.jsp";
    public static final String  CHAMP_PSEUDO     = "pseudo";
    public static final String  CHAMP_EMAIL      = "email";
    public static final String  CHAMP_PASS       = "pwd";
    public static final String  CHAMP_CONF       = "pwd2";
    public static final String  CHAMP_PRENOM     = "prenom";
    public static final String  CHAMP_NOM        = "nom";

    // stockage des donnée pour test
    ArrayList<String>           pseudos          = new ArrayList<String>();
    String                      erreurs          = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        pseudos.add( "Somath" );
        pseudos.add( "Teddy" );
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( TEST_JSP ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        /* Récupération des champs du formulaire. */
        String pseudo = request.getParameter( CHAMP_PSEUDO );

        String email = request.getParameter( CHAMP_EMAIL );

        String motDePasse = request.getParameter( CHAMP_PASS );

        String confirmation = request.getParameter( CHAMP_CONF );

        String nom = request.getParameter( CHAMP_NOM );

        String prenom = request.getParameter( CHAMP_PRENOM );

        try {
            confirmPseudo( pseudo );
            request.setAttribute( CHAMP_PSEUDO, pseudo );
        } catch ( Exception e ) {
            erreurs += e.getMessage();
        }
        try {
            confirmEmail( email );
            request.setAttribute( CHAMP_EMAIL, email );
        } catch ( Exception e ) {
            erreurs += e.getMessage();
        }
        try {
            confirmMdp( motDePasse );
            confirmConfirm( motDePasse, confirmation );
            request.setAttribute( CHAMP_PASS, motDePasse );
            request.setAttribute( CHAMP_CONF, confirmation );
        } catch ( Exception e ) {
            erreurs += e.getMessage();
        }
        request.setAttribute( CHAMP_NOM, nom );
        request.setAttribute( CHAMP_PRENOM, prenom );
        request.setAttribute( "erreurs", erreurs );

        if ( erreurs == "" ) {
            doLog( request, response );
        } else {
            erreurs = "";
            doGet( request, response );
        }
    }

    public void confirmPseudo( String p ) throws Exception {
        if ( pseudos.contains( p ) ) {
            throw new Exception( "Pseudo non disponible<br/>" );
        }
    }

    public void confirmEmail( String e ) throws Exception {

        if ( e != null && e.trim().length() != 0 ) {

            if ( !e.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {

                throw new Exception( "Merci de saisir une adresse mail valide.<br/>" );

            }

        } else {

            throw new Exception( "Merci de saisir une adresse mail.<br/>" );

        }

    }

    public void confirmMdp( String m ) throws Exception {
        if ( m.length() < 8 ) {
            throw new Exception( "Votre mot de passe doit faire plus de 8 Caractères.<br/>" );
        }
    }

    public void confirmConfirm( String m1, String m2 ) throws Exception {
        if ( !m1.equals( m2 ) ) {
            throw new Exception( "Les deux mots de passe doivent être identique.<br/>" );
        }
    }

    protected void doLog( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( "/"
                + "WEB-INF/SignIn.jsp" ).forward( request, response );
    }

}
