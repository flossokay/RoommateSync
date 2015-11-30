package com.roommatesync;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsfeedAdapter extends BaseAdapter {
    private Context context;


    public NewsfeedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return " ";
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.newsfeed_post, null);
        }


        TextView usrText = (TextView) convertView.findViewById(R.id.post_user);
        TextView msgText = (TextView) convertView.findViewById(R.id.post_msg);
        TextView dateText = (TextView) convertView.findViewById(R.id.post_date);

        usrText.setText("Martin Chiu");
        msgText.setText("My Parents are coming into town this weekend");
        dateText.setText("SomeDate");

        return convertView;
    }
}
