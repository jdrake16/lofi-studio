package edu.cnm.deepdive.lofistudio.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * The type Song sample.
 */
@Entity(
    indices = {
        @Index(value = {"sample_id", "track", "slot"})
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

  private int track;

  private int slot;

//  @ColumnInfo(name = "overlap")
//  private int overlap;

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets song id.
   *
   * @return the song id
   */
  public long getSongId() {
    return songId;
  }

  /**
   * Sets song id.
   *
   * @param songId the song id
   */
  public void setSongId(long songId) {
    this.songId = songId;
  }

  /**
   * Gets sample id.
   *
   * @return the sample id
   */
  public long getSampleId() {
    return sampleId;
  }

  /**
   * Sets sample id.
   *
   * @param sampleId the sample id
   */
  public void setSampleId(long sampleId) {
    this.sampleId = sampleId;
  }

  /**
   * Gets sequence.
   *
   * @return the sequence
   */
  public int getTrack() {
    return track;
  }

  /**
   * Sets sequence.
   *
   * @param track the sequence
   */
  public void setTrack(int track) {
    this.track = track;
  }

  /**
   * Gets repetitions.
   *
   * @return the repetitions
   */
  public int getSlot() {
    return slot;
  }

  /**
   * Sets repetitions.
   *
   * @param slot the repetitions
   */
  public void setSlot(int slot) {
    this.slot = slot;
  }

//  public int getOverlap() {
//    return overlap;
//  }
//
//  public void setOverlap(int overlap) {
//    this.overlap = overlap;
//  }
}
