package com.smapley.prints_yun.mode;

import com.smapley.prints_yun.http.result.IndexResult;

/**
 * Created by smapley on 16/4/29.
 */
public class KeyboardItemMode extends BaseMode {

    private int type = 0;

    private String itemText;

    private IndexResult.Edit edit;



    public KeyboardItemMode( String itemText) {
        this.type = 1;
        this.itemText=itemText;
    }

    public KeyboardItemMode(IndexResult.Edit edit) {
        this.type = 2;
        this.edit=edit;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public IndexResult.Edit getEdit() {
        return edit;
    }

    public void setEdit(IndexResult.Edit edit) {
        this.edit = edit;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public int getType() {
        return type;
    }
}
