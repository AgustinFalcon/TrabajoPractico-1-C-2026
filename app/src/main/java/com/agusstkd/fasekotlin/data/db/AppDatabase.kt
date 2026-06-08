package com.agusstkd.fasekotlin.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.agusstkd.fasekotlin.DesaMobileApp
import com.agusstkd.fasekotlin.data.db.dao.UserDao
import com.agusstkd.fasekotlin.model.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao


    companion object {
        private var INSTANCE: AppDatabase? = null

        // Singleton
        fun getDatabase(): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    DesaMobileApp.instance.applicationContext,
                    AppDatabase::class.java,
                    "desa_mobile_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }

}