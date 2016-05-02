package com.smapley.prints_yun.http.result;

import com.smapley.prints_yun.http.JsonResponseParser;

import org.xutils.http.annotation.HttpResponse;

/**
 * Created by smapley on 16/4/28.
 */
@HttpResponse(parser = JsonResponseParser.class)
public class IndexResult {
    private Space space;
    private Edit edit;
    private Keyboard keyboard;


    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Edit getEdit() {
        return edit;
    }

    public void setEdit(Edit edit) {
        this.edit = edit;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public class Space {
        private Integer count;
        private String content;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public class Edit {
        private Integer count;
        private Integer limit;
        private Integer root;

        public Integer getRoot() {
            return root;
        }

        public void setRoot(Integer root) {
            this.root = root;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }
    }

    public class Keyboard {
        private Integer layout;
        private String cell;


        public void setLayout(Integer layout) {
            this.layout = layout;
        }

        public Integer getLayout() {
            return layout;
        }

        public String getCell() {
            return cell;
        }

        public void setCell(String cell) {
            this.cell = cell;
        }
    }
}
