package com.roommatesync;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

//http://192.168.1.133/newsfeed.json

public class NewsfeedFragment extends RoboFragment {

    @InjectView(R.id.post_list) private ListView lView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.newsfeed_fragment, container, false);
    }

    public void onResume(){
        super.onResume();
        NewsfeedAdapter newsfeedAdapter = new NewsfeedAdapter(getActivity());
        lView.setAdapter(newsfeedAdapter);
        newsfeedAdapter.notifyDataSetChanged();
    }
}
