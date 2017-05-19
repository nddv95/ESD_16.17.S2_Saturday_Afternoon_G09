package vn.edu.hcmute.esdenglishpractise.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import vn.edu.hcmute.esdenglishpractise.Model.Sound;

/**
 * Created by nddv9 on 19/05/2017.
 */

public class SoundRepository implements BaseRepository<Sound> {
    private  DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public SoundRepository(Context context){
        this.databaseHelper = new DatabaseHelper(context);
        this.databaseHelper.OpenDataBase();
        this.database = this.databaseHelper.getmDatabase();
    }
    @Override
    public List<Sound> findAll() throws Exception {
        return null;
    }

    @Override
    public Sound findById(int id) throws Exception {
        String selectSound = "select ID,SOUND,YOUTUBEID,IMG,AUDIO,TEXT from SOUND where ID = ?";
        Cursor cursor = this.database.rawQuery(selectSound,new String[]{String.valueOf(id)});
        if(cursor != null)
            cursor.moveToFirst();
        Sound sound = new Sound(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
        return sound;
    }
}
