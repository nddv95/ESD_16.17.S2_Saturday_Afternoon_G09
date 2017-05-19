package vn.edu.hcmute.esdenglishpractise.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.hcmute.esdenglishpractise.Model.Lesson;
import vn.edu.hcmute.esdenglishpractise.Model.Sound;
import vn.edu.hcmute.esdenglishpractise.Model.Word;

/**
 * Created by nddv9 on 19/05/2017.
 */

public class WordRepository implements BaseRepository<Word> {
    private  DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private SoundRepository soundRepository;
    public WordRepository(Context context){
        this.databaseHelper = new DatabaseHelper(context);
        this.databaseHelper.OpenDataBase();
        this.database = this.databaseHelper.getmDatabase();
        this.soundRepository = new SoundRepository(context);
    }
    @Override
    public List<Word> findAll() throws Exception {
        return null;
    }

    public List<Word> findWordBySoundId (int soundId) throws Exception{
        String selectWord = "select ID,WORD,AUDIO,PRO,MEAN,SOUND,STAR from WORD where SOUND = ?";
        List<Word> wordsBySound = new ArrayList<>();
        Cursor cursor = this.database.rawQuery(selectWord,new String[]{String.valueOf(soundId)});
        if(cursor.moveToFirst()){
            do{
                Sound sound = this.soundRepository.findById(cursor.getInt(5));
                Word word = new Word(cursor.getInt(0),cursor.getString(1), cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),sound,cursor.getInt(6));
                wordsBySound.add(word);
            }while (cursor.moveToNext());
        }
        return wordsBySound;
    }

    @Override
    public Word findById(int id) throws Exception {
        String selectWord = "select ID,WORD,AUDIO,PRO,MEAN,SOUND,STAR from WORD where ID = ?";
        Cursor cursor = this.database.rawQuery(selectWord,new String[]{String.valueOf(id)});
        if(cursor != null)
            cursor.moveToFirst();
        Sound sound = null;
        if(cursor.getInt(5)!=0)
            sound = this.soundRepository.findById(cursor.getInt(5));
        Word word = new Word(cursor.getInt(0),cursor.getString(1), cursor.getString(2),
                cursor.getString(3),cursor.getString(4),sound,cursor.getInt(6));
        return word;
    }

    public void updateStar(int star, int id) throws Exception{
        ContentValues contentValues = new ContentValues();
        contentValues.put("STAR",star);
        this.database.update("WORD",contentValues,"ID = ?", new String[]{String.valueOf(id)});
    }
}
