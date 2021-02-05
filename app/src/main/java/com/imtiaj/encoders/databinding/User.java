package com.imtiaj.encoders.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class User extends BaseObservable {
    String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public User() {
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    @Bindable
    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }
}
