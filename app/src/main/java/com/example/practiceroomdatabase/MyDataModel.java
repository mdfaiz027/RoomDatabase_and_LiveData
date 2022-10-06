package com.example.practiceroomdatabase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyDataModel extends ViewModel {
    String title="";

    private MutableLiveData<String> mutableLiveData;

    public MutableLiveData<String> getMutableLiveData(){
        mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(""+title);
        return mutableLiveData;
    }

    public void insertValues(String info){
        title = info;
        mutableLiveData.setValue(title);
    }
}
