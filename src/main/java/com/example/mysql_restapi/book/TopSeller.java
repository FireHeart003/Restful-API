package com.example.mysql_restapi.book;

public class TopSeller {
    private String title;
    private int copiesSold;

    public TopSeller(String title, int copiesSold) {
        this.title = title;
        this.copiesSold = copiesSold;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }
}

