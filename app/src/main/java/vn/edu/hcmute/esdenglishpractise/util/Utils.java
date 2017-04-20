package vn.edu.hcmute.esdenglishpractise.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by nddv9 on 20/04/2017.
 */

public class Utils {
    private static final String IMAGE_PATH = "image/";
    private static final String AUDIO_PATH = "audio/";

    public static Bitmap LoadImageFromAssert(Context context, String fileName) {
        InputStream open = null;
        try {
            open = context.getAssets().open(IMAGE_PATH + fileName + ".png");
            return BitmapFactory.decodeStream(open);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (open != null) {
                    open.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void PlaySoundFromAssert(Context context, String soundPath) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor afd = context.getAssets().openFd(AUDIO_PATH + soundPath + ".mp3");
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
