package com.example.firebase

import android.provider.BaseColumns


class DatabaseContract {
    object Penduduk : BaseColumns {
        const val TABLE_NAME = "Penduduk"
        const val COLUMN_NAME_NAMA = "Nama"
        const val COLUMN_NAME_USIA = "Usia"


        const val SQL_CREATE_TABLE = "CREATE TABLE ${TABLE_NAME} (" +
                 "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                 "${COLUMN_NAME_NAMA} TEXT," +
                 "${COLUMN_NAME_USIA} INTEGER" +
                    ")"

        const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"


    }

}