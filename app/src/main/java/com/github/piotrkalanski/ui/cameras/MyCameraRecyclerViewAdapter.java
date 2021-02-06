package com.github.piotrkalanski.ui.cameras;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.piotrkalanski.R;
import com.github.piotrkalanski.model.Camera;
import com.github.piotrkalanski.ui.camera.CameraActivity;

import java.util.List;


/**
 * {@link RecyclerView.Adapter} that can display a {@link com.github.piotrkalanski.model.Camera}.
 */
public class MyCameraRecyclerViewAdapter extends RecyclerView.Adapter<MyCameraRecyclerViewAdapter.ViewHolder> {

    private final List<Camera> mValues;
    private final FragmentActivity activity;

    public MyCameraRecyclerViewAdapter(FragmentActivity activity, List<Camera> items) {
        mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_camera_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Camera item = mValues.get(position);

        Drawable drawable = ContextCompat.getDrawable(holder.cardView.getContext(), item.getDrawable());
        holder.imageView.setImageDrawable(drawable);
        holder.imageView.setContentDescription(item.getModel());

        holder.description.setText(item.getDescription());

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, CameraActivity.class);
            intent.putExtra(CameraActivity.KEY_CAMERA, item);
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View cardView;
        public final ImageView imageView;
        public final TextView description;

        public ViewHolder(View view) {
            super(view);
            cardView = view;
            imageView = view.findViewById(R.id.image);
            description = view.findViewById(R.id.description);
        }
    }
}
