package edu.cnm.deepdive.lofistudio.controller;

import android.os.Bundle;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.lofistudio.R;
import edu.cnm.deepdive.lofistudio.viewmodel.MainViewModel;


public class sampleFragment extends Fragment {

  private MainViewModel mainViewModel;
  private ListView samples;

  public sampleFragment(ListView samples) {
    this.samples = samples;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //noinspection ConstantConditions
    mainViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
//    mainViewModel.getQuotes().observe(getViewLifecycleOwner(),
//        (quotes) -> quoteList.setAdapter(new QuoteAdapter(getContext(), quotes, this)));
  }

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.activity_tracks, container, false);
    View sampleList = root.findViewById(R.id.samples);
    View selectSample = null;
    selectSample.setOnClickListener((v) -> selectSample(0));
    return root;
  }

  private Object selectSample(int i) {
    return null;
  }
}
