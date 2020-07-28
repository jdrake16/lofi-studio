package edu.cnm.deepdive.lofistudio.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import edu.cnm.deepdive.lofistudio.R;
import edu.cnm.deepdive.lofistudio.model.entity.Sample;
import edu.cnm.deepdive.lofistudio.view.TracksAdapter.Holder;

public class TracksAdapter extends RecyclerView.Adapter<Holder>{

  private final Context context;
  private final Sample[][] samples;
  private final GridLayoutManager layoutManager;
  @ColorInt
  private final int emptySlot;
  @ColorInt
  private final int assignedSlot;

  public TracksAdapter(Context context, Sample[][] samples,
      GridLayoutManager layoutManager) {
    this.context = context;
    this.samples = samples;
    this.layoutManager = layoutManager;
    emptySlot = ContextCompat.getColor(context, R.color.emptySlot);
    assignedSlot = ContextCompat.getColor(context, R.color.assignedSlot);
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_track_slot, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return samples.length * samples[0].length;
  }

  class Holder extends RecyclerView.ViewHolder {

    private final TextView name;

    private Holder(@NonNull View itemView) {
      super(itemView);
      name=itemView.findViewById(R.id.name);
    }

    private void bind(int position) {
      int track = position % layoutManager.getSpanCount();
      int slot = position / layoutManager.getSpanCount();
      Sample sample = samples[track][slot];
      if (sample == null) {
        itemView.setBackgroundColor(emptySlot);
        name.setText("");
      } else {
        itemView.setBackgroundColor(assignedSlot);
        name.setText(sample.getName());
      }
    }
  }
}
