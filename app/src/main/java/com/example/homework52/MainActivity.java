package com.example.homework52;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private TextView textViewCounter;
    private Button buttonCounter;
    private TextView textView;
    private EditText editText;
    private Button buttonChange;
    private MainViewModel viewModel;
    private int count = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        textViewCounter = findViewById(R.id.textView);
        buttonCounter = findViewById(R.id.button);

        textView = findViewById(R.id.textView2);
        editText = findViewById(R.id.editTextText);
        buttonChange = findViewById(R.id.button2);
        buttonCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.incrementClickCount();
            }
        });
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                if (!name.isEmpty()) {
                    viewModel.setName(name);
                }
            }
        });
        viewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String newName) {
                textView.setText("Привет, " + newName + "!");
            }
        });
        viewModel.getClickCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer newCount) {
                textViewCounter.setText("Количество кликов: " + newCount);
            }
        });
    }
}