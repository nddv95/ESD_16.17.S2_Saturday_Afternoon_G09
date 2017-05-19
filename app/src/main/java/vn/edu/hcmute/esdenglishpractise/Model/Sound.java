package vn.edu.hcmute.esdenglishpractise.Model;


/**
 * Created by nddv9 on 20/04/2017.
 */

public class Sound extends BaseModel{
    public String sound;
    public String youtubeid;
    public String img;
    public String audio;
    public String text;

    public Sound(int id, String sound, String youtubeid, String img, String audio, String text) {
        super(id);
        this.sound = sound;
        this.youtubeid = youtubeid;
        this.img = img;
        this.audio = audio;
        this.text = text;
    }

}
