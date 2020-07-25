package edu.cnm.deepdive.lofistudio.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import edu.cnm.deepdive.lofistudio.R;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import java.util.List;

//public class SampleListAdapter extends
//    ListView.Adapter<SampleListAdapter.SampleViewHolder> {
//
//  private final Context context;
//  private final List<Sample> samples;
//
//  public SampleListAdapter(Context context, List<Sample> samples) {
//    super();
//    this.context = context;
//    this.samples = samples;
//  }
//
//  @NonNull
//  @Override
//  public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
//      int viewType) {
//    View view = LayoutInflater.from(context).inflate(R.layout.activity_tracks, parent, false);
//    return new SampleViewHolder(view);
//  }
//
//  @Override
//  public void onBindViewHolder(@NonNull SampleListAdapter.SampleViewHolder holder, int position) {
//    holder.bind(position);
//  }
//
//  @Override
//  public int getItemCount() {
//    return samples.size();
//  }
//
//  class SampleViewHolder extends ListView.ViewHolder {
//
//
//    private final Spinner imageSpinner;
//    private Sample sample;
//
//    public SampleViewHolder(@NonNull View itemView) {
//      super(itemView);
//      sample = itemView.findViewById(R.id.samples);
//
//      imageSpinner = itemView.findViewById(R.id.sample_search_spinner);
//      imageSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//        @Override
//        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
////          String item = adapterView.getItemAtPosition(position).toString();
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> adapterView) {
//
//        }
//      });
//    }
//
//    private void bind(int position) {
//     sample = samples.get(position);
//      name.setText(gallery.getTitle());
//      description.setText(gallery.getDescription());
//      GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(context,
//          gallery.getImages());
//      imageSpinner.setAdapter(galleryImageAdapter);
//    }
//
//  }
//
//}





