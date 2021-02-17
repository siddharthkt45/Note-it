package com.example.note_it

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)          // to perform a task in background, we use coroutines
                                            // such as 'suspend' so that the heavy tasks don't make
    @Delete                                 // the app laggy. The suspend keyword ensures that this
    suspend fun delete(note: Note)          // function can only be called by a background thread

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>         // LiveData<> is a type of wrapper over the data
}                                                   // It can be observed from anywhere and thus the
                                                    // changes are also visible