package edu.cnm.deepdive.lofistudio.service;


import android.app.Application;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.lofistudio.model.entity.Playlist;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import edu.cnm.deepdive.lofistudio.model.entity.SongPlaylist;
import edu.cnm.deepdive.lofistudio.model.entity.SongSample;

@Database(
    entities = {Song.class, Sample.class, Playlist.class, SongPlaylist.class, SongSample.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public class LofiStudioDatabase extends RoomDatabase {

  private static final String DB_NAME = "lofi_studio_db";

  private static Application context;

  public static void setContext(Application context) {
    LofiStudioDatabase.context = context;
  }

//comment

}
