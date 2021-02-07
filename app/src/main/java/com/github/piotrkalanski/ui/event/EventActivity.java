package com.github.piotrkalanski.ui.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.piotrkalanski.R;
import com.github.piotrkalanski.model.Event;

public class EventActivity extends AppCompatActivity {
    public static final String KEY_EVENT = "EVENT";

    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        event = (Event)getIntent().getExtras().get(KEY_EVENT);

        ((TextView)findViewById(R.id.title)).setText(event.getTitle());
        ((TextView)findViewById(R.id.time)).setText(event.getTime());

        // TODO - image
    }

    public void onPlayClicked(View view) {
        // TODO - move to event play activity
    }
}