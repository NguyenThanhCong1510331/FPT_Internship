package com.example.asus.livestream_app;

import java.util.ArrayList;

/**
 * Created by Welcome on 6/19/2018.
 */

public class ChapterInfo {

    private String result;
    private String errorCode;
    private ArrayList<ChapterItemInfo> lstItemInfo;

    public ChapterInfo(String result, String errorCode, ArrayList<ChapterItemInfo> lstItemInfo) {
        this.result = result;
        this.errorCode = errorCode;
        this.lstItemInfo = lstItemInfo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ArrayList<ChapterItemInfo> getLstItemInfo() {
        return lstItemInfo;
    }

    public void setLstItemInfo(ArrayList<ChapterItemInfo> lstItemInfo) {
        this.lstItemInfo = lstItemInfo;
    }
}
