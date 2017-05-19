package vn.edu.hcmute.esdenglishpractise.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by nddv9 on 05/05/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();
    public static final String DB_NAME = "data.db";
    private SQLiteDatabase mDatabase;
    private Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.mContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     */
    public void CreateDatabase() throws IOException {
        boolean isExist = CheckDataBase();
        Log.d(TAG, "Start create database");
        if (isExist) {
            //do nothing - database already exist
            Log.d(TAG, "Database already exist");
        } else {
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            Log.d(TAG, "Start copy database");
            this.getReadableDatabase();
            try {
                copyDatabase();
            } catch (IOException e) {
                throw new Error("Error coping database");
            }
        }

    }

    private void copyDatabase() throws IOException {
        Log.d(TAG, "Copping database");
        InputStream input = mContext.getAssets().open(DB_NAME);
        String outPath = mContext.getDatabasePath(DB_NAME).getPath();
        OutputStream output = new FileOutputStream(outPath);
        byte[] buffer = new byte[1024];
        int lenght;
        while ((lenght = input.read(buffer)) > 0) {
            output.write(buffer, 0, lenght);
        }
        output.flush();
        output.close();
        input.close();
    }

    private boolean CheckDataBase() {
        Log.d(TAG, "Check database exist");
        File dbFile = mContext.getDatabasePath(DB_NAME);
        return dbFile.exists();
    }

    public void OpenDataBase() throws SQLException {
        Log.d(TAG, "Open database");
        String databasePath = mContext.getDatabasePath(DB_NAME).getPath();
        mDatabase = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    @Override
    public synchronized void close() {
        if (mDatabase != null) {
            mDatabase.close();
        }
        super.close();
    }

    public SQLiteDatabase getmDatabase() {
        return mDatabase;
    }
}

