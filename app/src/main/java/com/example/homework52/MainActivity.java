package com.example.homework52;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private TextView textViewCounter;
    private Button buttonCounter;
    private TextView textView;
    private EditText editText;
    private Button buttonChange;
    private MainViewModel viewModel;
    private static final String KEY_NAME = "name";
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

        if (savedInstanceState != null) {
            String savedName = savedInstanceState.getString(KEY_NAME);
            if (savedName != null && !savedName.isEmpty()) {
                viewModel.setName(savedName);
                textView.setText("Привет, " + viewModel.getName() + "!");
            }
        }

        buttonCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textViewCounter.setText("Количество кликов: " + count);
            }
        });

        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                if (!name.isEmpty()) {
                    viewModel.setName(name);
                    textView.setText("Привет, " + viewModel.getName() + "!");
                }
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_NAME, viewModel.getName());
    }
}