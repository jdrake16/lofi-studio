package edu.cnm.deepdive.lofistudio.model.pojo;

import androidx.room.Ignore;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.model.entity.Song;
import java.util.List;

public class SongImport extends Song {

  @Ignore
  private List<SampleImport> samples;

  public List<SampleImport> getSamples() {
    return samples;
  }

  public void setSamples(
      List<SampleImport> samples) {
    this.samples = samples;
  }

  public static class SampleImport {
    private String name;
    private int track;
    private int slot;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getTrack() {
      return track;
    }

    public void setTrack(int track) {
      this.track = track;
    }

    public int getSlot() {
      return slot;
    }

    public void setSlot(int slot) {
      this.slot = slot;
    }
  }

}
