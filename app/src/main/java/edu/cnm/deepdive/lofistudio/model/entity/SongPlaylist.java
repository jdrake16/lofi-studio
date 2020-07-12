package edu.cnm.deepdive.lofistudio.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

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

  public long getPlaylistId() {
    return playlistId;
  }

  public void setPlaylistId(long playlistId) {
    this.playlistId = playlistId;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }
}
