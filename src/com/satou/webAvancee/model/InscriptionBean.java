package com.satou.webAvancee.model;

import java.util.ArrayList;

public class InscriptionBean {

    public String pseudo;
    public String email;
    public String pwd;
    public String pwd2;
    public String prenom;
    public String nom;
    public String erreurs = "";

    public String getErreurs() {
        return erreurs;
    }

    public void setErreurs( String erreurs ) {
        this.erreurs = erreurs;
    }

    public boolean             resultats;

    public static final String CHAMP_PSEUDO = "pseudo";
    public static final String CHAMP_EMAIL  = "email";
    public static final String CHAMP_PASS   = "pwd";
    public static final String CHAMP_CONF   = "pwd2";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String CHAMP_NOM    = "nom";

    public ArrayList<String>   pseudos      = new ArrayList<String>();

    public InscriptionBean( String pseudo, String email, String pwd, String pwd2, String prenom, String nom ) {
        super();

        // pour les test
        pseudos.add( "Somath" );
        pseudos.add( "Teddy" );

        this.prenom = prenom;
        this.nom = nom;

        try {
            confirmPseudo( pseudo );
        } catch ( Exception e ) {
            erreurs += e.getMessage();
        }
        try {
            confirmEmail( email );
        } catch ( Exception e ) {
            erreurs += e.getMessage();
        }
        try {
            confirmMdp( pwd );
            confirmConfirm( pwd, pwd2 );

        } catch ( Exception e ) {
            erreurs += e.getMessage();
        }

        if ( erreurs == "" ) {
            resultats = true; // pour une inscription valide
        } else {
            resultats = false; // pour une inscription incorrecte

        }
    }

    public void confirmPseudo( String p ) throws Exception {
        if ( pseudos.contains( p ) ) {
            throw new Exception( "Pseudo non disponible<br/>" );
        }
        this.setPseudo( p );
    }

    public void confirmEmail( String e ) throws Exception {

        if ( e != null && e.trim().length() != 0 ) {

            if ( !e.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {

                throw new Exception( "Merci de saisir une adresse mail valide.<br/>" );

            }

        } else {

            throw new Exception( "Merci de saisir une adresse mail.<br/>" );

        }
        this.setEmail( e );

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
        this.setPwd( m1 );
        this.setPwd2( m2 );
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo( String pseudo ) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd( String pwd ) {
        this.pwd = pwd;
    }

    public String getPwd2() {
        return pwd2;
    }

    public void setPwd2( String pwd2 ) {
        this.pwd2 = pwd2;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public boolean isResultats() {
        return resultats;
    }

    public void setResultats( boolean resultats ) {
        this.resultats = resultats;
    }
}
