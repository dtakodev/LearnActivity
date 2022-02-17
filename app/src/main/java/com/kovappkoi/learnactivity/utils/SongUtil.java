package com.kovappkoi.learnactivity.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class SongUtil {
//định hình lại chương trình muốn làm
    //how to get all music in android device
    //thử nghiệm code
    //
    public static List<String> getAllSongFromDevice(Activity context) {
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION
        };

        @SuppressLint("Recycle") Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                null);

        List<String> songs = new ArrayList<>();
        while (cursor.moveToNext()) {
            songs.add(cursor.getString(0) + "||" + cursor.getString(1) + "||" + cursor.getString(2) + "||" + cursor.getString(3) + "||" + cursor.getString(4) + "||" + cursor.getString(5));
        }

        return songs;
    }
}
