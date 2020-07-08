package edu.cnm.deepdive.lofistudio.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = {
        @Index(value = {"song_id", "sequence"}),
        @Index(value = {"sample_id", "sequence", "repetitions"})
    },
    foreignKeys = {
        @ForeignKey(entity = Song.class,
            parentColumns = "song_id", childColumns = "song_id", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Sample.class,
            parentColumns = "sample_id", childColumns = "sample_id", onDelete = ForeignKey.CASCADE)
    }
)
public class SongSample {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "song_sample_id")
  private long id;

  @ColumnInfo(name = "song_id", index = true)
  private long songId;

  @ColumnInfo(name = "sample_id", index = true)
  private long sampleId;

  private int sequence;

  private int repetitions;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSongId() {
    return songId;
  }

  public void setSongId(long songId) {
    this.songId = songId;
  }

  public long getSampleId() {
    return sampleId;
  }

  public void setSampleId(long sampleId) {
    this.sampleId = sampleId;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public int getRepetitions() {
    return repetitions;
  }

  public void setRepetitions(int repetitions) {
    this.repetitions = repetitions;
  }
}
