package com.satou.webAvancee.model;

public class SessionBean {

    private static final String PSEUDO_BAND = "pseudoh";
    private static final String PWD_BAND    = "pwdh";
    private static final String LOGIN_BOOL  = "login";

    private String              pseudo;
    private String              pwd;
    private boolean             login;

    public SessionBean( String pseudo, String pwd ) {
        super();
        this.pseudo = pseudo;
        this.pwd = pwd;

        if ( check( pseudo, pwd ) ) {
            this.login = true;
        } else {
            this.login = false;
        }
    }

    public boolean check( String p, String l ) {
        if ( p == "test" ) {
            if ( l == "1234" ) {
                return true;
            }
        }
        return true;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo( String pseudo ) {
        this.pseudo = pseudo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd( String pwd ) {
        this.pwd = pwd;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin( boolean login ) {
        this.login = login;
    }

}
