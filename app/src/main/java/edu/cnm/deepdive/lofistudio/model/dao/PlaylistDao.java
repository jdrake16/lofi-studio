package edu.cnm.deepdive.lofistudio.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import edu.cnm.deepdive.lofistudio.model.entity.Playlist;
import io.reactivex.Single;

@Dao
public interface PlaylistDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Playlist playlist);





}
