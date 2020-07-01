package edu.cnm.deepdive.lofistudio.model.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = @Index(value = "name", unique = true)
)
public class Sample {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "sample_id")
  private long id;

  @ColumnInfo(name = "name")
  private String name;

  @ColumnInfo(name = "content")
  private String content;

  private int length;


}
