package com.example.listview1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StaticDemo extends AppCompatActivity {
    private static final String[] items = {"lorem", "ipsum", "dolor", "sit", "amet", "consectetuer",
                                           "adipiscing", "elit", "morbi", "vel", "ligula", "vitae",
                                           "arcu", "aliquet", "mollis", "etiam", "vel", "erat",
                                           "placerat", "ante", "porttitor", "sodales",
                                           "pellentesque", "augue", "purus"};

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = findViewById(R.id.list);
        textView = findViewById(R.id.selection);
        listView.setAdapter(new IconAdapter());
    }

    private class IconAdapter extends ArrayAdapter<String> {

        public IconAdapter() {
            super(StaticDemo.this.getApplicationContext(), R.layout.row_element, R.id.textView, items);
        }

        public View getView(int pos, View convertView, ViewGroup parent) {
            View row = super.getView(pos, convertView, parent);
            ImageView icon = row.findViewById(R.id.icon);
            if (items[pos].length()>4) {
                icon.setImageResource(R.drawable.star);
            }
            else {
                icon.setImageResource(R.drawable.star_border);
            }
            return(row);
        }
    }
}
