package edu.cnm.deepdive.lofistudio.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Relation;
import edu.cnm.deepdive.lofistudio.model.entity.Song;

public class SongInPlaylist extends Song {

  @Relation(entity = Song.class, entityColumn = "song_id", parentColumn = "song_id")
  private Song song;

  public Song getSource() {
    return song;
  }

  public void setSource(Song song) {
    this.song = song;
  }




}
