package edu.cnm.deepdive.lofistudio.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.lofistudio.model.entity.Playlist;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface PlaylistDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Playlist playlist);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Playlist... playlists);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Playlist> playlists);

  @Update
  Single<Integer> update(Playlist... playlists);

  @Delete
  Single<Integer> delete(Playlist... playlists);

  @Transaction
  @Query("SELECT * FROM Playlist ORDER BY name")
  Single<List<Playlist>> selectAll();



}
