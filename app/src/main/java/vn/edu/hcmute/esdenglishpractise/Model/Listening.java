package vn.edu.hcmute.esdenglishpractise.Model;


/**
 * Created by nddv9 on 05/05/2017.
 */

public class Listening extends BaseModel{
    public Word key;
    public Word word1;
    public Word word2;
    public Lesson lesson;

    public Listening(int id, Word key, Word word1, Word word2, Lesson lesson) {
        super(id);
        this.key = key;
        this.word1 = word1;
        this.word2 = word2;
        this.lesson = lesson;
    }
}
