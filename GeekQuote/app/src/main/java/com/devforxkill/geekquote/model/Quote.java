package com.devforxkill.geekquote.model;

import java.io.Serializable;
import java.time.LocalDate;

// Javabean c'est une classe qui a les attributs privées, au moins constructeur et les getter/setter
// Serializable permet de stocker un objet sous forme de byte avec un identifiant unique
// Tous les objets de java sont sérializable de base (Strgin, Arraylist, LocalDate...)
public class Quote implements Serializable {

    private String strQuote;
    private int rating;
    private LocalDate date;

    public Quote(String strQuote, int rating, LocalDate date) {
        this.strQuote = strQuote;
        this.rating = rating;
        this.date = date;
    }

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return strQuote;
    }
}
