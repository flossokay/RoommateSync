package com.roommatesync;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

//http://192.168.1.133/newsfeed.json

public class NewsfeedFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.newsfeed_fragment, container, false);
    }

    public void onResume(){
        super.onResume();
        NewsfeedAdapter newsfeedAdapter = new NewsfeedAdapter(getActivity());
        ListView lView = (ListView) getActivity().findViewById(R.id.post_list);
        lView.setAdapter(newsfeedAdapter);
        newsfeedAdapter.notifyDataSetChanged();
    }
}
