package vn.edu.hcmute.esdenglishpractise.Model;

import com.orm.SugarRecord;

/**
 * Created by nddv9 on 18/04/2017.
 */

public class Lesson extends SugarRecord {

    public String name;
    public Sound sound1;
    public Sound sound2;
    public String img;

    public Lesson(String name, Sound sound1, Sound sound2, String img) {
        this.name = name;
        this.sound1 = sound1;
        this.sound2 = sound2;
        this.img = img;
    }

    public Lesson() {

    }
}
