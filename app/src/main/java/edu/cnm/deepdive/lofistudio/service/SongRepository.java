package edu.cnm.deepdive.lofistudio.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.lofistudio.model.dao.PlaylistDao;
import edu.cnm.deepdive.lofistudio.model.dao.SampleDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongPlaylistDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongSampleDao;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class SongRepository {

  private final Context context;
  private final LofiStudioDatabase database;
  private final SampleDao sampleDao;
  private final PlaylistDao playlistDao;
  private final SongPlaylistDao songPlaylistDao;
  private final SongSampleDao songSampleDao;
  private final SongDao songDao;


  public SongRepository(Context context) {
    this.context = context;
    database = LofiStudioDatabase.getInstance();
    sampleDao = database.getSampleDao();
    songDao = database.getSongDao();
    playlistDao = database.getPlaylistDao();
    songPlaylistDao = database.getSongPlaylistDao();
    songSampleDao = database.getSongSampleDao();

  }

  public Single<List<Song>> selectAll() {
    return songDao.selectAll();
  }

  public LiveData<List<Song>> getAll() {
    return songDao.getAll();

  }


//  public Single<Song> get(long id) {
//    return SongDao.selectById(id)
//        .subscribeOn(Schedulers.io());
//  }

  public Completable save(Song song) {
    if (song.getId() == 0) {
      return Completable.fromSingle(songDao.insert(song))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(songDao.update(song))
          .subscribeOn(Schedulers.io());
    }

  }

  public Completable delete(Song song) {
    if (song.getId() == 0) {
      return Completable.fromAction(new Action() {
        @Override
        public void run() throws Exception {
        }
      })
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(songDao.delete(song))
          .subscribeOn(Schedulers.io());

    }
  }


}
