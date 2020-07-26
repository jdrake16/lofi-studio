package edu.cnm.deepdive.lofistudio.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.lofistudio.model.entity.Playlist;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface SongDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Song song);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Song... songs);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Song> songs);

  @Update
  Single<Integer> update(Song... songs);

  @Delete
  Single<Integer> delete(Song... songs);

  @Query("SELECT * FROM Song ORDER BY name")
  Single<List<Song>> selectAll();

  @Query("SELECT * FROM Song ORDER BY name")
  LiveData<List<Song>> getAll();

  @Query("SELECT * FROM Song WHERE song_id = :songId")
  Single<Song> selectById(long songId);

}
