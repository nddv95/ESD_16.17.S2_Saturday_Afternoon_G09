package vn.edu.hcmute.esdenglishpractise.Model;

/**
 * Created by nddv9 on 20/04/2017.
 */

public class Word {
    private int idWord;
    private String word;
    private String urlWordSound;
    private String mean;
    private String pronoun;
    private int idSound;

    public Word() {
    }

    public Word(int idWord, String word, String urlWordSound, String mean, String pronoun, int idSound) {
        this.idWord = idWord;
        this.word = word;
        this.urlWordSound = urlWordSound;
        this.mean = mean;
        this.pronoun = pronoun;
        this.idSound = idSound;
    }

    public int getIdWord() {
        return idWord;
    }

    public void setIdWord(int idWord) {
        this.idWord = idWord;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getUrlWordSound() {
        return urlWordSound;
    }

    public void setUrlWordSound(String urlWordSound) {
        this.urlWordSound = urlWordSound;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public int getIdSound() {
        return idSound;
    }

    public void setIdSound(int idSound) {
        this.idSound = idSound;
    }
}
