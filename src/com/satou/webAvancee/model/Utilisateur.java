package com.satou.webAvancee.model;

public class Utilisateur {
    private String pseudo;
    private String pwd;

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

    public Utilisateur() {
        super();
    }

}
