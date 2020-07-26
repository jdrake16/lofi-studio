package edu.cnm.deepdive.lofistudio.controller;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.lofistudio.R;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.viewmodel.MainViewModel;

public class TracksActivity extends AppCompatActivity {



  private boolean playing = false;
  private ListView samples;
  private MainViewModel viewModel;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tracks);

    samples = findViewById(R.id.samples);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.getSamples().observe(this, (samples) -> {
      ArrayAdapter<Sample> adapter =
          new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, samples);
      this.samples.setAdapter(adapter);
    });

    viewModel.getTrackSamples().observe(this, (trackSamples) -> {

      for (int i = 0; i < trackSamples.length; i++) {
        String trackId = "track_" + (i + 1);
        int layoutId = getResources().getIdentifier(trackId, "id", getPackageName());
        ViewGroup track = findViewById(layoutId);
        track.removeAllViews();
        for (int j = 0; j < trackSamples[i].length; j++) {
          // TODO inflate item_track_slot layout and set its background color and sample name according to trackSample[i][j]
          track.addView(View.inflate(this, R.layout.item_track_slot, samples));
          track.setBackgroundColor(R.layout.item_track_slot);
          track.setId(layoutId);


        }
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.transport, menu);
    return true;
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    super.onPrepareOptionsMenu(menu);
    menu.findItem(R.id.play).setVisible(!playing);
    menu.findItem(R.id.pause).setVisible(playing);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled = true;
    switch (item.getItemId()) {
      case R.id.play:
        playing = true;
        // TODO make any processing required to start playing.
        invalidateOptionsMenu();
        break;
      case R.id.pause:
        playing = false;
        // TODO make any processing required to pause playback.
        invalidateOptionsMenu();
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }


}
