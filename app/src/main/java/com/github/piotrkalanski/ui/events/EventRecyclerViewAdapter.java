package com.github.piotrkalanski.ui.events;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.piotrkalanski.R;
import com.github.piotrkalanski.model.Event;
import com.github.piotrkalanski.ui.event.EventActivity;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * {@link RecyclerView.Adapter} that can display a {@link com.github.piotrkalanski.model.Event}.
 */
public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder> {

    private final List<Event> mValues;
    private final FragmentActivity activity;

    public EventRecyclerViewAdapter(FragmentActivity activity, List<Event> items) {
        mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_event_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Event item = mValues.get(position);

        holder.title.setText(item.getTitle());
        holder.time.setText(item.getTime());
        Picasso.get().load(item.getUrl()).into(holder.imageView);

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, EventActivity.class);
            intent.putExtra(EventActivity.KEY_EVENT, item);
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View cardView;
        public final TextView title;
        public final TextView time;
        public final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            cardView = view;
            title = view.findViewById(R.id.title);
            time = view.findViewById(R.id.time);
            imageView = view.findViewById(R.id.image);
        }
    }
}
