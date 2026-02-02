package com.ranjit.harmony.pojo;

public class Book {

    public Book(String title, String author, int published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    private String author;
    private int published;

    @Override
    public String toString() {
        return "title=" + title + " author=" + author + " published=" + published;
    }


}
