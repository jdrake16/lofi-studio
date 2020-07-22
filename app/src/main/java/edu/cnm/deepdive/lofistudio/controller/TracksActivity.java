package edu.cnm.deepdive.lofistudio.controller;

import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.lofistudio.R;

public class TracksActivity extends AppCompatActivity {

  private boolean playing = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tracks);
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
