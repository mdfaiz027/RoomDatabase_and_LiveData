package com.example.practiceroomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText title, amount;
    Button submit;
    MyDataModel myDataModel;

    RecyclerView recyclerView;
    MyRecyclerAdapter myRecyclerAdapter;
    List<MyModelClass> myModelClassList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        amount = findViewById(R.id.amount);
        submit = findViewById(R.id.submit);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        myRecyclerAdapter = new MyRecyclerAdapter(getApplicationContext(), myModelClassList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myRecyclerAdapter);

        myDataModel = new ViewModelProvider(this).get(MyDataModel.class);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputTitle = title.getText().toString();
                String inputAmount = amount.getText().toString();

                if(inputTitle.trim().equals("")){
                    title.setError("Enter a valid title");
                }else if(inputAmount.trim().equals("")){
                    amount.setError("Enter a valid amount");
                }else{
                    closeKeyboard();
                    databaseHelper.expenseDao().insertInfo(new Expense(inputTitle, inputAmount));
                }
             }
        });

        databaseHelper.expenseDao().getAllExpenses().observe(this, new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expenses) {
                if(expenses!=null){
                    myModelClassList.clear();

                    for(int i=0; i< expenses.size(); i++){
                        myModelClassList.add(new MyModelClass(""+expenses.get(i).getTitle(), ""+expenses.get(i).getAmount()));

                    }
                    myRecyclerAdapter.notifyDataSetChanged();
                }
            }
        });
    }
    //Close keyboard when clicked on solve button
    private void closeKeyboard() {
        View view = getCurrentFocus();
        if(view!=null){
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}