package com.rohan.rohan.f7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class BatchAndYearActivity extends AppCompatActivity {
    private EditText batch;

    String[] s = {"F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8"};
    ArrayList<String> arrayList = new ArrayList<>();

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_and_year);
        final TinyDB tinyDB = new TinyDB(this);


        radioGroup=findViewById(R.id.getYear);
        batch = findViewById(R.id.batch);

        final Spinner spinner = findViewById(R.id.getYearSpinner);

        TextView tv = (TextView) spinner.getChildAt(0);
        //tv.setTextColor(getResources().getColor(R.color.grey_2));
        //tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
        batch.setText(tinyDB.getString("BATCH"));

        arrayList.addAll(Arrays.asList(s).subList(0, 16));
        findViewById(R.id.savebatch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1 = spinner.getSelectedItem().toString();
                    if (!s1.equals("SELECT YEAR"))
                    {
                        tinyDB.putString("YEAR", s1);
                        if (arrayList.contains(batch.getText().toString().trim().toUpperCase())) {
                            tinyDB.putString("BATCH", batch.getText().toString().trim().toUpperCase());
                            startActivity(new Intent(BatchAndYearActivity.this,ChooseSubjects.class));
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "PLEASE ENTER CORRECTLY.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(BatchAndYearActivity.this, "Select Year", Toast.LENGTH_SHORT).show();
                    }


                }catch (Exception Ignore){}



            }
        });



    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BatchAndYearActivity.this, ChooseSubjects.class));
        finish();
    }
}
