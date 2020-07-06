package edu.cnm.deepdive.lofistudio.service;


import android.app.Application;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.lofistudio.R;
import edu.cnm.deepdive.lofistudio.model.dao.PlaylistDao;
import edu.cnm.deepdive.lofistudio.model.dao.SampleDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongDao;
import edu.cnm.deepdive.lofistudio.model.entity.Playlist;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import edu.cnm.deepdive.lofistudio.model.entity.SongPlaylist;
import edu.cnm.deepdive.lofistudio.model.entity.SongSample;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;

@Database(
    entities = {Song.class, Sample.class, Playlist.class, SongPlaylist.class, SongSample.class},
    version = 1,
    exportSchema = true
)
public abstract class LofiStudioDatabase extends RoomDatabase {

  private static final String DB_NAME = "lofi_studio_db";

  private static Application context;

  public static void setContext(Application context) {
    LofiStudioDatabase.context = context;
  }


  public abstract PlaylistDao getPlaylistDao();

  public abstract SongDao getSongDao();

  // TODO add getters for all daos

  public static LofiStudioDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final LofiStudioDatabase INSTANCE =
        Room.databaseBuilder(context, LofiStudioDatabase.class, DB_NAME)
            .addCallback(new LofiStudioCallback())
            .build();
  }

  private static class LofiStudioCallback extends Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      try {
        // TODO read sample list from raw resource; save mp3 resources to files?
        // TODO add sample instances to database
        Map<Sample, List<Sample>> map = parseFile(R.raw.drum_loop_restored_retro);
        persist(map);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    private Map<Sample, List<Sample>> parseFile(int resourceId) throws IOException {
      try (InputStream input = LofiStudioDatabase.context.getResources().openRawResource(resourceId);


      ) {

  }

}


