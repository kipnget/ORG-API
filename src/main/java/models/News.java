package models;

import java.util.Objects;

public class News {
    private String title;
    private String content;
    private String writtenBy;
    private int id;
    private int department_id;
    private String type;

    public News(String title, String content, String writtenBy) {
        this.title = title;
        this.content = content;
        this.writtenBy = writtenBy;
        this.type="Organisation news";
    }


    public News(String title, String content, String writtenBy,int department_id) {
        this.title = title;
        this.content = content;
        this.writtenBy = writtenBy;
        this.department_id= department_id;
        this.type="Department news";

    }


}
