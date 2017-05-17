package vn.edu.hcmute.esdenglishpractise.Model;

import com.orm.SugarRecord;

/**
 * Created by nddv9 on 20/04/2017.
 */

public class Sound extends SugarRecord {
    public String sound;
    public String youtubeid;
    public String img;
    public String audio;
    public String text;

    public Sound(String sound, String youtubeid, String img, String audio, String text) {
        this.sound = sound;
        this.youtubeid = youtubeid;
        this.img = img;
        this.audio = audio;
        this.text = text;
    }

    public Sound() {

    }
}
