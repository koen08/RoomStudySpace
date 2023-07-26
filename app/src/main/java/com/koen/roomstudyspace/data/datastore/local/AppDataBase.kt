package com.koen.roomstudyspace.data.datastore.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.koen.roomstudyspace.data.datastore.local.user.UserDao
import com.koen.roomstudyspace.data.datastore.local.user.UserEntity


val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {

        database.execSQL("" +
                "CREATE TABLE new_user_table (\n" +
                "  uId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "  last_name TEXT NOT NULL DEFAULT '',\n" +
                "  first_name TEXT NOT NULL DEFAULT '',\n" +
                "  age INTEGER NOT NULL DEFAULT 0,\n" +
                "  picture TEXT NOT NULL DEFAULT ''\n" +
                ")")

        database.execSQL("INSERT INTO new_user_table (uId, first_name, last_name, age, picture) SELECT uId, first_name, last_name, 0, '' FROM user_table")

        database.execSQL("DROP TABLE user_table")

        database.execSQL("ALTER TABLE new_user_table RENAME TO user_table")

 /*       database.execSQL("ALTER TABLE user_table ADD COLUMN age INTEGER NOT NULL DEFAULT 0 AFTER last_name")
        database.execSQL("ALTER TABLE user_table ADD COLUMN picture VARCHAR NOT NULL DEFAULT '' AFTER age")*/
    }
}

@Database(entities = [UserEntity::class], version = 2)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao() : UserDao
}