package edu.cnm.deepdive.lofistudio.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.model.entity.Song;

public class SampleInSong extends Sample {

  @Relation(entity = Sample.class, entityColumn = "sample_id", parentColumn = "sample_id")
  private Sample sample;

  public Sample getSource() {
    return sample;
  }

  public void setSource(Sample sample) {
    this.sample = sample;
  }

}
