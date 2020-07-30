package edu.cnm.deepdive.lofistudio.service;


import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission.Read;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.lofistudio.R;
import edu.cnm.deepdive.lofistudio.model.dao.PlaylistDao;
import edu.cnm.deepdive.lofistudio.model.dao.SampleDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongPlaylistDao;
import edu.cnm.deepdive.lofistudio.model.dao.SongSampleDao;
import edu.cnm.deepdive.lofistudio.model.entity.Playlist;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import edu.cnm.deepdive.lofistudio.model.entity.SongPlaylist;
import edu.cnm.deepdive.lofistudio.model.entity.SongSample;
import edu.cnm.deepdive.lofistudio.model.pojo.SongImport;
import edu.cnm.deepdive.lofistudio.model.pojo.SongImport.SampleImport;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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

  public abstract SongSampleDao getSongSampleDao();

  public abstract SongPlaylistDao getSongPlaylistDao();

  public abstract SampleDao getSampleDao();

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
      Map<String, Long> sampleIdMap = new HashMap<>();

      Gson gson = new GsonBuilder()
          .create();
      try (
          InputStream input = context.getResources().openRawResource(R.raw.songs);
          Reader reader = new InputStreamReader(input);
      ) {
        SongImport[] songs = gson.fromJson(reader, SongImport[].class);
        List<Sample> samples = parseFile(R.raw.lofi_samples_twenty);
        LofiStudioDatabase.getInstance().getSampleDao().insert(samples)
            .subscribeOn(Schedulers.io())
            .map((ids) -> {
              for(int i = 0; i < samples.size(); i++) {
                sampleIdMap.put(samples.get(i).getName(), ids.get(i));
              }
              return ids;
            })
            .flatMap((sampleIds) -> {
              return LofiStudioDatabase.getInstance().getSongDao().insert(songs)
                  .flatMap((ids) -> {
                    List<SongSample> assignments = new LinkedList<>();
                    for (int i = 0; i < songs.length; i++) {
                      for (SampleImport si: songs[i].getSamples()) {
                        SongSample assignment = new SongSample();
                        assignment.setSongId(ids.get(i));
                        assignment.setTrack(si.getTrack());
                        assignment.setSlot(si.getSlot());
                        assignment.setSampleId(sampleIdMap.get(si.getName()));
                        assignments.add(assignment);
                      }
                    }
                    return LofiStudioDatabase.getInstance().getSongSampleDao().insert(assignments);
                  });
            })
            .subscribe();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    private List<Sample> parseFile(int resourceId) throws IOException {
      try (
          InputStream input = LofiStudioDatabase.context.getResources().openRawResource(resourceId);
          Reader reader = new InputStreamReader(input);
          CSVParser parser = CSVParser.parse(
              reader, CSVFormat.EXCEL.withIgnoreSurroundingSpaces().withIgnoreEmptyLines());
      ) {
        List<Sample> samples = new LinkedList<>();
        for (CSVRecord record: parser) {
          Sample sample = new Sample();
          sample.setName(record.get(0).trim());
          sample.setContent(record.get(1).trim());
          samples.add(sample);
        }
        return samples;
      }

    }
  }

}


