package edu.cnm.deepdive.lofistudio.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import edu.cnm.deepdive.lofistudio.model.entity.SongPlaylist;
import edu.cnm.deepdive.lofistudio.model.entity.SongSample;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface SongSampleDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(SongSample songSample);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(SongSample... songSamples);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<SongSample> songSamples);

  @Update
  Single<Integer> update(SongSample... songSamples);

  @Delete
  Single<Integer> delete(SongSample... songSamples);

  @Query("SELECT * FROM SongSample ORDER BY song_sample_id")
  Single<List<Song>> selectAll();

}
