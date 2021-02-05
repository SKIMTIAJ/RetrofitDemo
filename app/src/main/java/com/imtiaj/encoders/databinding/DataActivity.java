package com.imtiaj.encoders.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.imtiaj.encoders.R;

public class DataActivity extends AppCompatActivity {

    ActivityDataBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_data);

       dataBinding.setUser(new User("Imtiaj"));
    }
}