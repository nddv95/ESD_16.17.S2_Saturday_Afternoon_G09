package vn.edu.hcmute.esdenglishpractise.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.hcmute.esdenglishpractise.Model.Lesson;
import vn.edu.hcmute.esdenglishpractise.Model.Sound;

/**
 * Created by nddv9 on 19/05/2017.
 */

public class LessonRepository implements BaseRepository<Lesson> {
    private  DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private SoundRepository soundRepository;
    public LessonRepository(Context context){
        this.databaseHelper = new DatabaseHelper(context);
        this.databaseHelper.OpenDataBase();
        this.database = this.databaseHelper.getmDatabase();
        this.soundRepository = new SoundRepository(context);
    }
    @Override
    public List<Lesson> findAll() throws Exception{

        List<Lesson> lstLesson = new ArrayList<>();
        Cursor cursor = this.database.rawQuery("select ID,NAME,SOUND1,SOUND2,IMG from LESSON",null);
        if(cursor.moveToFirst()){
            do{
                Sound sound1 = this.soundRepository.findById(cursor.getInt(2));
                Sound sound2 = this.soundRepository.findById(cursor.getInt(3));
                Lesson lesson = new Lesson(cursor.getInt(0),cursor.getString(1),sound1 ,sound2, cursor.getString(4));
                lstLesson.add(lesson);
            }while (cursor.moveToNext());
        }
        return lstLesson;
    }

    @Override
    public Lesson findById(int id) throws Exception{
        String selectLesson = "select ID,NAME,SOUND1,SOUND2,IMG from LESSON where ID = ?";
        Cursor cursor = this.database.rawQuery(selectLesson,new String[]{String.valueOf(id)});
        if(cursor != null)
            cursor.moveToFirst();
        Sound sound1 = this.soundRepository.findById(cursor.getInt(2));
        Sound sound2 = this.soundRepository.findById(cursor.getInt(3));
        Lesson lesson = new Lesson(cursor.getInt(0),cursor.getString(1),sound1 ,sound2, cursor.getString(4));
        return lesson;
    }
}
