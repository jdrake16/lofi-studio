package edu.cnm.deepdive.lofistudio.model.entity;


import androidx.room.Entity;
import androidx.room.Index;

@Entity(
    indices = @Index(value = "name", unique = true))

public class Sample {

}
