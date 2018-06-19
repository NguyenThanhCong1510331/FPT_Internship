package com.example.asus.livestream_app;

/**
 * Created by Welcome on 6/19/2018.
 */

public class ChapterItemInfo {

    public ChapterItemInfo(){

    }
    public ChapterItemInfo(String chapterId, String chapterName){
        this.chapterId=chapterId;
        this.chapterName = chapterName;
    }
    private String chapterId;

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    private String chapterName;

}
