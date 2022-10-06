package com.example.practiceroomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Query("select * from expense")
    LiveData<List<Expense>> getAllExpenses();

    @Insert
    void insertInfo(Expense expense);

    @Update
    void updateInfo(Expense expense);

    @Delete
    void deleteInfo(Expense expense);
}
