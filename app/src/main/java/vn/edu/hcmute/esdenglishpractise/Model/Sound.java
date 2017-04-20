package vn.edu.hcmute.esdenglishpractise.Model;

/**
 * Created by nddv9 on 20/04/2017.
 */

public class Sound {
    private int idSound;
    private String soundName;
    private String youtubeId;
    private String textGuide;
    private String urlSound;
    private String urtImageGuide;

    public Sound() {
    }

    public Sound(int idSound, String soundName, String youtubeId, String textGuide, String urlSound, String urtImageGuide) {
        this.idSound = idSound;
        this.soundName = soundName;
        this.youtubeId = youtubeId;
        this.textGuide = textGuide;
        this.urlSound = urlSound;
        this.urtImageGuide = urtImageGuide;
    }

    public int getIdSound() {
        return idSound;
    }

    public void setIdSound(int idSound) {
        this.idSound = idSound;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getTextGuide() {
        return textGuide;
    }

    public void setTextGuide(String textGuide) {
        this.textGuide = textGuide;
    }

    public String getUrlSound() {
        return urlSound;
    }

    public void setUrlSound(String urlSound) {
        this.urlSound = urlSound;
    }

    public String getUrtImageGuide() {
        return urtImageGuide;
    }

    public void setUrtImageGuide(String urtImageGuide) {
        this.urtImageGuide = urtImageGuide;
    }
}
