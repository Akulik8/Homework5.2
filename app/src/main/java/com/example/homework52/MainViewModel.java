package com.example.homework52;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
   // public String name = "ananimus";
    //public MutableLiveData<String> name = new MutableLiveData<>("ananimus");
   private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
