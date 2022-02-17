package com.kovappkoi.learnactivity.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.kovappkoi.learnactivity.db.SongReaderContract.SQL_DELETE_ENTRIES

class SongDBHelper(
    context: Context
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase!!.execSQL(SongReaderContract.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Song.db"
    }
}

object SongReaderContract {
    // Table contents are grouped together in an anonymous object.
    object SongEntry : BaseColumns {
        const val TABLE_NAME = "songs"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_SUB = "sub"
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_AUTHOR = "author"
    }

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${SongEntry.TABLE_NAME} (" +
                "${SongEntry.COLUMN_NAME_ID} INTEGER PRIMARY KEY," +
                "${SongEntry.COLUMN_NAME_TITLE} TEXT," +
                "${SongEntry.COLUMN_NAME_SUB} TEXT," +
                "${SongEntry.COLUMN_NAME_AUTHOR} TEXT)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${SongEntry.TABLE_NAME}"

}
