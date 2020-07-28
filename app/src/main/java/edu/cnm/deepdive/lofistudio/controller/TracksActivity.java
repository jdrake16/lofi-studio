package edu.cnm.deepdive.lofistudio.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.lofistudio.R;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.view.TracksAdapter;
import edu.cnm.deepdive.lofistudio.viewmodel.MainViewModel;

public class TracksActivity extends AppCompatActivity {



  private boolean playing = false;
  private ListView samples;
  private MainViewModel viewModel;
  private SeekBar trackLength;
  private RecyclerView tracks;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tracks);

    samples = findViewById(R.id.samples);
    trackLength = findViewById(R.id.track_length);
    trackLength.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
          viewModel.resizeTracks(MainViewModel.NUM_TRACKS, progress);
        }
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });
    tracks = findViewById(R.id.tracks);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.getSamples().observe(this, (samples) -> {
      ArrayAdapter<Sample> adapter =
          new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, samples);
      this.samples.setAdapter(adapter);
    });

    viewModel.getTrackSamples().observe(this, (trackSamples) -> {
      TracksAdapter adapter = new TracksAdapter(this, trackSamples,
          (GridLayoutManager) tracks.getLayoutManager());
      tracks.setAdapter(adapter);




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
