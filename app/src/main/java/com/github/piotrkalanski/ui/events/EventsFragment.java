package com.github.piotrkalanski.ui.events;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.piotrkalanski.R;

public class EventsFragment extends Fragment {

    private EventsViewModel viewModel;

    public EventsFragment() {
        // TODO - support for multiple users
        // TODO - new ViewModelProvider(this).get(EventsViewModel.class) ?
        this.viewModel = new EventsViewModel("1");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();

            this.viewModel.events.observe(getViewLifecycleOwner(), events -> {
                RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new EventRecyclerViewAdapter(getActivity(), events));
            });
        }
        return view;
    }
}