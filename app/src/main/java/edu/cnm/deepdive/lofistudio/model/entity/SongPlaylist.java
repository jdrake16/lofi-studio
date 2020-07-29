package edu.cnm.deepdive.lofistudio.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * The type Song playlist.
 */
@Entity(
    indices = {
        @Index(value = {"playlist_id", "sequence"}),
        @Index(value = {"playlist_id", "song_id"}, unique = true)
        // "unique = true" to prevent duplicates in playlist
    },
    foreignKeys = {
        @ForeignKey(entity = Song.class,
            parentColumns = "song_id", childColumns = "song_id", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Playlist.class,
            parentColumns = "playlist_id", childColumns = "playlist_id", onDelete = ForeignKey.CASCADE)
    }
)
public class SongPlaylist {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "song_playlist_id")
  private long id;

  @ColumnInfo(name = "song_id", index = true)
  private long songId;

  @ColumnInfo(name = "playlist_id", index = true) // "index = true" for foreign keys
  private long playlistId;

  @ColumnInfo(name = "sequence")
  private int sequence;

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
   * Gets playlist id.
   *
   * @return the playlist id
   */
  public long getPlaylistId() {
    return playlistId;
  }

  /**
   * Sets playlist id.
   *
   * @param playlistId the playlist id
   */
  public void setPlaylistId(long playlistId) {
    this.playlistId = playlistId;
  }

  /**
   * Gets sequence.
   *
   * @return the sequence
   */
  public int getSequence() {
    return sequence;
  }

  /**
   * Sets sequence.
   *
   * @param sequence the sequence
   */
  public void setSequence(int sequence) {
    this.sequence = sequence;
  }
}
