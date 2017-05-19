package vn.edu.hcmute.esdenglishpractise.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.hcmute.esdenglishpractise.Model.Lesson;
import vn.edu.hcmute.esdenglishpractise.Model.Listening;
import vn.edu.hcmute.esdenglishpractise.Model.Word;

/**
 * Created by nddv9 on 19/05/2017.
 */

public class ListeningRepository implements BaseRepository<Listening> {
    private  DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private WordRepository wordRepository;
    private LessonRepository lessonRepository;

    public ListeningRepository(Context context){
        this.databaseHelper = new DatabaseHelper(context);
        this.databaseHelper.OpenDataBase();
        this.database = this.databaseHelper.getmDatabase();
        this.wordRepository = new WordRepository(context);
        this.lessonRepository = new LessonRepository(context);
    }
    @Override
    public List<Listening> findAll() throws Exception {
        return null;
    }

    public List<Listening> findByLesson(int lessonId) throws Exception{
        List<Listening> listenings = new ArrayList<>();
        Cursor cursor = this.database.rawQuery("select ID,KEY,WORD1,WORD2,LESSON from LISTENING where LESSON = ?", new String[]{String.valueOf(lessonId)});
        if(cursor.moveToFirst()){
            do {
                Word key = this.wordRepository.findById(cursor.getInt(1));
                Word word1 = this.wordRepository.findById(cursor.getInt(2));
                Word word2 = this.wordRepository.findById(cursor.getInt(3));
                Lesson lesson = this.lessonRepository.findById(cursor.getInt(4));
                Listening listening = new Listening(cursor.getInt(0),key,word1,word2,lesson);
                listenings.add(listening);
            }while (cursor.moveToNext());
        }
        return listenings;
    }

    @Override
    public Listening findById(int id) throws Exception {
        return null;
    }
}
