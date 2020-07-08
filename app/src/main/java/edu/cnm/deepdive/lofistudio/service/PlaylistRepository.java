package edu.cnm.deepdive.lofistudio.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.lofistudio.model.dao.PlaylistDao;
import edu.cnm.deepdive.lofistudio.model.dao.SampleDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongPlaylistDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongSampleDao;
import edu.cnm.deepdive.lofistudio.model.entity.Playlist;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class PlaylistRepository {


  private final Context context;
  private final LofiStudioDatabase database;
  private final SampleDao sampleDao;
  private final PlaylistDao playlistDao;
  private final SongPlaylistDao songPlaylistDao;
  private final SongSampleDao songSampleDao;
  private final SongDao songDao;

  public PlaylistRepository(Context context) {
    this.context = context;
    database = LofiStudioDatabase.getInstance();
    sampleDao = database.getSampleDao();
    songDao = database.getSongDao();
    playlistDao = database.getPlaylistDao();
    songPlaylistDao = database.getSongPlaylistDao();
    songSampleDao = database.getSongSampleDao();
  }

  //  public LiveData<List< /* pojo would be here*/ >> getAll() {
//    return SampleDao.selectAll();
//
//  }
//
//  public Single< /* pojo? */> get(long id) {
//    return SampleDao.selectById(id)
//        .subscribeOn(Schedulers.io());
//  }

  public Completable save(Playlist playlist) {
    if (playlist.getId() == 0) {
      return Completable.fromSingle(playlistDao.insert(playlist))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(playlistDao.update(playlist))
          .subscribeOn(Schedulers.io());
    }

  }

  public Completable delete(Playlist playlist) {
    if (playlist.getId() == 0) {
      return Completable.fromAction(new Action() {
        @Override
        public void run() throws Exception {
        }
      })
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(playlistDao.delete(playlist))
          .subscribeOn(Schedulers.io());

    }
  }


}
