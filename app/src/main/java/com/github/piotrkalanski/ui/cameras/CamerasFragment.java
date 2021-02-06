package com.github.piotrkalanski.ui.cameras;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.piotrkalanski.R;

public class CamerasFragment extends Fragment {

    private CamerasViewModel viewModel;

    public CamerasFragment() {
        // TODO - support for multiple users
        // TODO - new ViewModelProvider(this).get(CamerasViewModel.class) ?
        this.viewModel = new CamerasViewModel("u1");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cameras_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();

            this.viewModel.cameras.observe(getViewLifecycleOwner(), getCamerasResponse -> {
                RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new MyCameraRecyclerViewAdapter(getCamerasResponse.items));
            });
        }
        return view;
    }
}