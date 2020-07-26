package edu.cnm.deepdive.lofistudio.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.lofistudio.model.entity.Playlist;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import edu.cnm.deepdive.lofistudio.service.PlaylistRepository;
import edu.cnm.deepdive.lofistudio.service.SampleRepository;
import edu.cnm.deepdive.lofistudio.service.SongRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;


public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final SampleRepository sampleRepository;
  private final SongRepository songRepository;
  private final PlaylistRepository playlistRepository;
  private final MutableLiveData<Throwable> throwable;
  private final MutableLiveData<Sample> sample;
  private final MutableLiveData<Sample> song;
  private final MutableLiveData<Sample> playlist;
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
    pending = new CompositeDisposable();
  }

  public LiveData<List<Sample>> getSample() {
    return sampleRepository.getAll();
  }

//  public LiveData<List<Playlist>> getPlaylist() {
//    return playlistRepository.getAll();
//  }
//
//  public LiveData<Song> getSong() {
//    return songRepository.getAll();
//  }

//  public LiveData<Throwable> getThrowable() {
//    return throwable;
//  }

//  public void setQuoteId(long id) {
//    throwable.setValue(null);
//    pending.add(
//        quoteRepository.get(id)
//            .subscribe(
//                (quote) -> this.quote.postValue(quote),
//                (throwable) -> this.throwable.postValue(throwable)
//            )
//    );
//  }

//  public void saveQuote(Quote quote) {
//    throwable.setValue(null);
//    pending.add(
//        quoteRepository.save(quote)
//            .subscribe(
//                () -> {
//                },
//                (throwable) -> this.throwable.postValue(throwable)
//            )
//    );
//  }
//
//  public void deleteQuote(Quote quote) {
//    throwable.setValue(null);
//    pending.add(
//        quoteRepository.delete(quote)
//            .subscribe(
//                () -> {
//                },
//                (throwable) -> this.throwable.postValue(throwable)
//            )
//    );
//  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }

}