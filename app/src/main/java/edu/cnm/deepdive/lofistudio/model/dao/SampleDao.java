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
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface SampleDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Sample sample);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Sample... samples);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Sample> samples);

  @Update
  Single<Integer> update(Sample... samples);

  @Delete
  Single<Integer> delete(Sample... samples);

  @Transaction
  @Query("SELECT * FROM Sample ORDER BY name")
  Single<List<Song>> selectAll();

}
