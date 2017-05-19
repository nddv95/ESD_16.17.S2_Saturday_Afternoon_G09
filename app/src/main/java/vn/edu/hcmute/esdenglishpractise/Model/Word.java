package vn.edu.hcmute.esdenglishpractise.Model;


/**
 * Created by nddv9 on 20/04/2017.
 */

public class Word extends BaseModel{
    public String word;
    public String audio;
    public String pro;
    public String mean;
    public Sound sound;
    public int star;

    public Word(int id, String word, String audio, String pro, String mean, Sound sound, int star) {
        super(id);
        this.word = word;
        this.audio = audio;
        this.pro = pro;
        this.mean = mean;
        this.sound = sound;
        this.star = star;
    }

}
