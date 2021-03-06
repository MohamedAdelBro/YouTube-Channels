package com.example.internshipsegytask.channelsFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internshipsegytask.Home.HomeFragment;
import com.example.internshipsegytask.R;
import com.example.internshipsegytask.Adapters.VideoAdapter;
import com.example.internshipsegytask.Models.YouTubeVideos;

import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 */
public class Channel5_Fragment extends Fragment implements View.OnClickListener {


    View view;
    ImageView backIcon;
    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();
    Button mSubscribe, mUnsubscribe;
    TextView mSubscribeNumber;
    static int mSubNum = 0;


    public Channel5_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_channel5_, container, false);

        mSubscribe = view.findViewById(R.id.subscribe);
        mSubscribe.setOnClickListener(this);
        //------------------------------------------------------------------------------------------
        mUnsubscribe = view.findViewById(R.id.unsubscribe);
        mUnsubscribe.setOnClickListener(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.channel5_Rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FaLbaHA22FI\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CpiqdY99fes\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_e7Mr8qhSis\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/TzNmzZRo9uE\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/z3Bhg8rEDjA&t=16s\" frameborder=\"0\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
        initViews();

        mSubscribeNumber.setText(String.valueOf(mSubNum));

        return view;
    }

    private void initViews() {
        backIcon = view.findViewById(R.id.mGoBackIcon);
        backIcon.setOnClickListener(this);
        mSubscribeNumber = view.findViewById(R.id.subscribeNumber);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mGoBackIcon:
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.replace, new HomeFragment()).commit();
                break;
            case R.id.subscribe:
                mSubNum++;
                mSubscribeNumber.setText(String.valueOf(mSubNum));
                mSubscribe.setVisibility(View.GONE);
                mUnsubscribe.setVisibility(View.VISIBLE);
                break;
            case R.id.unsubscribe:
                mSubNum--;
                mSubscribeNumber.setText(String.valueOf(mSubNum));
                mUnsubscribe.setVisibility(View.GONE);
                mSubscribe.setVisibility(View.VISIBLE);
                break;
        }

    }
}
