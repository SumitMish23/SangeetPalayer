package com.example.multiscreenquiz;

public class model {
            //1-Creating three strings:-
    private String title,genre,date;
            //    2-Creating constructor


    public model(String title, String genre, String date) {
        this.title = title;
        this.genre = genre;
        this.date = date;
    }
    public model(){

    }
//    Getter and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
