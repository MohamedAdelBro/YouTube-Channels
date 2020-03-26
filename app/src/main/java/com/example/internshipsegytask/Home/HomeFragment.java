package com.example.internshipsegytask.Home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.internshipsegytask.Adapters.channelsVerticalAdapter;
import com.example.internshipsegytask.Models.ChanelsModel;
import com.example.internshipsegytask.R;
import com.example.internshipsegytask.channelsFragments.Channel1_Fragment;
import com.example.internshipsegytask.channelsFragments.Channel2_Fragment;
import com.example.internshipsegytask.channelsFragments.Channel3_Fragment;
import com.example.internshipsegytask.channelsFragments.Channel4_Fragment;
import com.example.internshipsegytask.channelsFragments.Channel5_Fragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements channelsVerticalAdapter.onclick {
    View view;
    RecyclerView mRecyclerView;
    ArrayList<ChanelsModel> mYoutubeVideos = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SetData();

        channelsVerticalAdapter mChannelsVerticalAdapter = new channelsVerticalAdapter(mYoutubeVideos, this, getContext());

        mRecyclerView.setAdapter(mChannelsVerticalAdapter);

        return view;
    }



    private void SetData() {
        ChanelsModel mChanelsModel = new ChanelsModel("Trailers", R.drawable.vid10);
        ChanelsModel mChanelsModel2 = new ChanelsModel("Sia Furler", R.drawable.vid7);
        ChanelsModel mChanelsModel3 = new ChanelsModel("Storror blog", R.drawable.vid8);
        ChanelsModel mChanelsModel4 = new ChanelsModel("Lost Leblanc", R.drawable.vid9);
        ChanelsModel mChanelsModel5 = new ChanelsModel("Space", R.drawable.vid2);

        mYoutubeVideos.add(mChanelsModel);
        mYoutubeVideos.add(mChanelsModel2);
        mYoutubeVideos.add(mChanelsModel3);
        mYoutubeVideos.add(mChanelsModel4);
        mYoutubeVideos.add(mChanelsModel5);
    }


    @Override
    public void on_click(String Name) {
        switch (Name) {
            case "Trailers":
                loadFragments(new Channel1_Fragment());
                break;
            case "Sia Furler":
                loadFragments(new Channel2_Fragment());
                break;
            case "Space":
                loadFragments(new Channel4_Fragment());
                break;
            case "Storror Blog":
                loadFragments(new Channel5_Fragment());
                break;

            case "Lost Leblanc":
                loadFragments(new Channel3_Fragment());
                break;
        }
    }

        private void loadFragments(Fragment mFragment) {
            FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction().replace(R.id.replace, mFragment).commit();
        }
    }

