package vn.edu.hcmute.esdenglishpractise.Model;

/**
 * Created by nddv9 on 18/04/2017.
 */

public class Lesson {
    private int id;
    private String lessonName;
    private String description;
    private String urlBackGround;
    private int idSound1;
    private int idSound2;

    public Lesson() {
    }

    public Lesson(int id, String lessonName, String description, String urlBackGround) {
        this.id = id;
        this.lessonName = lessonName;
        this.description = description;
        this.urlBackGround = urlBackGround;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlBackGround() {
        return urlBackGround;
    }

    public void setUrlBackGround(String urlBackGround) {
        this.urlBackGround = urlBackGround;
    }
}
