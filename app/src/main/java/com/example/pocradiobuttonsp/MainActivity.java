package com.example.pocradiobuttonsp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = findViewById(R.id.tv);
        ChipGroup chipGroup = findViewById(R.id.chipGroup);

        chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                if (checkedIds.isEmpty()) {
                    textView.setText("Tidak ada kategori masalah");
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i : checkedIds) {
                        Chip chip = findViewById(i);
                        stringBuilder.append(",").append(chip.getText());
                    }
                    textView.setText("Filter berdasarkan : "+stringBuilder.toString().replaceFirst(",",""));
                }
            }
        });
    }
}