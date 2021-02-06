package com.github.piotrkalanski.ui.events;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.piotrkalanski.R;
import com.github.piotrkalanski.model.Event;

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

        holder.description.setText(item.getTitle());

        // TODO - go to event details
//        holder.cardView.setOnClickListener(v -> {
//            Intent intent = new Intent(activity, EventActivity.class);
//            intent.putExtra(EventActivity.KEY_Event, item);
//            activity.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View cardView;
        public final TextView description;

        public ViewHolder(View view) {
            super(view);
            cardView = view;
            description = view.findViewById(R.id.description);
        }
    }
}
