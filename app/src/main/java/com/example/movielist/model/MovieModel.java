package com.example.movielist.model;

public class MovieModel {

    private String login;
    private String url;


    public MovieModel(String login, String url) {
        this.login = login;
        this.url = url;

    }

    public void setLogin(String login) {
        this.login = login;
    }



    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
