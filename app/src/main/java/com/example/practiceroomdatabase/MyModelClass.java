package com.example.practiceroomdatabase;

public class MyModelClass {
    String TitleName, AmountName;

    public MyModelClass(String titleName, String amountName) {
        TitleName = titleName;
        AmountName = amountName;
    }

    public String getTitleName() {
        return TitleName;
    }

    public void setTitleName(String titleName) {
        TitleName = titleName;
    }

    public String getAmountName() {
        return AmountName;
    }

    public void setAmountName(String amountName) {
        AmountName = amountName;
    }
}
