package edu.cnm.deepdive.lofistudio.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import edu.cnm.deepdive.lofistudio.model.entity.SongPlaylist;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface SongPlaylistDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(SongPlaylist songPlaylist);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(SongPlaylist... songPlaylists);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<SongPlaylist> songPlaylists);

  @Update
  Single<Integer> update(SongPlaylist... songPlaylists);

  @Delete
  Single<Integer> delete(SongPlaylist... songPlaylists);

  @Transaction
  @Query("SELECT * FROM SongPlaylist ORDER BY song_playlist_id")
  Single<List<SongPlaylist>> selectAll();

}
