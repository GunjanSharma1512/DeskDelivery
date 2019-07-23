package com.example.deskdeliverybyhungerbox;

import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {
    TimePicker timePicker;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        int hrs = 0;
        int mins = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            hrs = timePicker.getHour();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            mins = timePicker.getMinute();
        }
        submit = (Button) findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"The request has been placed: ID 1", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
