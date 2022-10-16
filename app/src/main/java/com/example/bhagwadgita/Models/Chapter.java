package com.example.bhagwadgita.Models;

public class Chapter {
    String chapter_num, chapter_name, chapter_title;

    public Chapter(String chapter_num, String chapter_name, String chapter_title) {
        this.chapter_num = chapter_num;
        this.chapter_name = chapter_name;
        this.chapter_title = chapter_title;
    }

    public String getChapter_num() {
        return chapter_num;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public String getChapter_title() {
        return chapter_title;
    }
}
