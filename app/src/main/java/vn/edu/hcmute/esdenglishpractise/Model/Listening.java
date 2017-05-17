package vn.edu.hcmute.esdenglishpractise.Model;

import com.orm.SugarRecord;

/**
 * Created by nddv9 on 05/05/2017.
 */

public class Listening extends SugarRecord {
    public Word key;
    public Word word1;
    public Word word2;
    public Lesson lesson;

    public Listening() {
    }

    public Listening(Word key, Word word1, Word word2, Lesson lesson) {

        this.key = key;
        this.word1 = word1;
        this.word2 = word2;
        this.lesson = lesson;
    }
}
