package edu.cnm.deepdive.lofistudio.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.service.PlaylistRepository;
import edu.cnm.deepdive.lofistudio.service.SampleRepository;
import edu.cnm.deepdive.lofistudio.service.SongRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import java.util.List;


public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  public static final int NUM_TRACKS = 4;
  public static final int INITIAL_SLOTS = 4;
  private final SampleRepository sampleRepository;
  private final SongRepository songRepository;
  private final PlaylistRepository playlistRepository;
  private final MutableLiveData<Throwable> throwable;
  private final MutableLiveData<Sample> sample;
  private final MutableLiveData<Sample> song;
  private final MutableLiveData<Sample> playlist;
  private final MutableLiveData<Sample[][]> trackSamples;
  private final CompositeDisposable pending;


  public MainViewModel(@NonNull Application application) {
    super(application);
    sampleRepository = new SampleRepository(application);
    playlistRepository = new PlaylistRepository(application);
    songRepository = new SongRepository(application);
    sample = new MutableLiveData<>();
    song = new MutableLiveData<>();
    playlist = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    trackSamples = new MutableLiveData<>(new Sample[0][0]);
    pending = new CompositeDisposable();
    resizeTracks(NUM_TRACKS, INITIAL_SLOTS);
  }

  public LiveData<List<Sample>> getSamples() {
    return sampleRepository.getAll();
  }

  public LiveData<Sample[][]> getTrackSamples() {
    return trackSamples;
  }

  public void assignSample(int track, int slot, Sample sample) {

    Sample[][] samples = trackSamples.getValue();
    if (!samples[track][slot].equals(sample)) {
      samples[track][slot] = sample;
      trackSamples.setValue(samples);
    }
  }

  public void resizeTracks(int tracks, int slots) {
    Sample[][] newSamples = new Sample[tracks][];
    Sample[][] oldSamples = trackSamples.getValue();
    int tracksToCopy = Math.min(newSamples.length, oldSamples.length);
    for (int trackIndex = 0; trackIndex < tracksToCopy; trackIndex++) {
      newSamples[trackIndex] = Arrays.copyOf(oldSamples[trackIndex], slots);
    }
    for (int trackIndex = tracksToCopy; trackIndex < newSamples.length; trackIndex++) {
      newSamples[trackIndex] = new Sample[slots];
    }
    trackSamples.setValue(newSamples);
  }

  public void clearTracks() {
    Sample[][] oldSamples = trackSamples.getValue();
    Sample[][] newSamples = new Sample[oldSamples.length][oldSamples[0].length];
    trackSamples.setValue(newSamples);
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }

}