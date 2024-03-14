package com.example.homework52;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<Integer> clickCount = new MutableLiveData<>();

    public void setName(String newName) {
        name.setValue(newName);
    }

    public MutableLiveData<String> getName() {
        return name;
    }
    public void incrementClickCount() {
        clickCount.setValue(clickCount.getValue() != null ? clickCount.getValue() + 1 : 1);
    }

    public MutableLiveData<Integer> getClickCount() {
        return clickCount;
    }
}
