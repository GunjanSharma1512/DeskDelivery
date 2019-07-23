package com.example.deskdeliverybyhungerbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.deskdeliverybyhungerbox.FoodType;
import com.example.deskdeliverybyhungerbox.R;

public class CustomAdapter extends BaseAdapter {
    Context context;
    FoodType[] foodTypes;
    LayoutInflater inflter;
    public CustomAdapter(Context applicationContext, FoodType[] foodTypes){
        this.context = applicationContext;
        this.foodTypes = foodTypes;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return foodTypes.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.grid_cell_view, null); // inflate the layout
        ImageView imageView = (ImageView) view.findViewById(R.id.imageFood);
        TextView textView = (TextView) view.findViewById(R.id.textFood);
        textView.setText(foodTypes[i].foodName);
        imageView.setImageResource(foodTypes[i].foodImage);
        //icon.setImageResource(logos[i]); // set logo images
        return view;
    }
}
