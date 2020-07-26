package edu.cnm.deepdive.lofistudio.controller;

import android.widget.ListView;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.lofistudio.R;
import edu.cnm.deepdive.lofistudio.viewmodel.MainViewModel;

//public class SongFragment extends Fragment {
//
//
//    private MainViewModel mainViewModel;
//    private ListView songList;
//
//    public static SongFragment newInstance() {
//        return new SongFragment();
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//        @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.song_fragment, container, false);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mainViewModel = ViewModelProviders.of(this).get(mainViewModel.class);
//        // TODO: Use the ViewModel
//    }
//
//}
