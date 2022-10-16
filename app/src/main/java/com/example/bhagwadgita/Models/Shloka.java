package com.example.bhagwadgita.Models;

public class Shloka {
    String shloka_num;
    String chapter_num;

    public Shloka(String shloka_num, String chapter_num) {

        this.shloka_num = shloka_num;
        this.chapter_num = chapter_num;
    }

    public String getShloka_num() {
        return shloka_num;
    }
    public String getChapter_num() {
        return chapter_num;
    }
}
