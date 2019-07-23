package com.example.deskdeliverybyhungerbox;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String[] listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.list_textview);
        listItem = getResources().getStringArray(R.array.food_items);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("item", value); // put image data in Intent
                startActivity(intent); // start Intent

            }
        });
    }
}
