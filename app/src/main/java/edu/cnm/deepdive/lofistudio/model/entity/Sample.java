package edu.cnm.deepdive.lofistudio.model.entity;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * The type Sample.
 */
@Entity(
    indices = @Index(value = "name", unique = true)
)
public class Sample {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "sample_id")
  private long id;

  @NonNull
  private String name;

  @NonNull
  private String content;

  private int length;


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
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets content.
   *
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets content.
   *
   * @param content the content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Gets length.
   *
   * @return the length
   */
  public int getLength() {
    return length;
  }

  /**
   * Sets length.
   *
   * @param length the length
   */
  public void setLength(int length) {
    this.length = length;
  }

  @NonNull
  @Override
  public String toString() {
    return name;
  }

  @Override
  public int hashCode() {
    return (31 * name.hashCode() + content.hashCode()) * 31 + Integer.hashCode(length);
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    return (this == obj)
        || (
            obj instanceof Sample
            && hashCode() == obj.hashCode()
            && name.equals(((Sample) obj).name)
            && content.equals(((Sample) obj).content)
            && length == ((Sample) obj).length
        );
  }
}
