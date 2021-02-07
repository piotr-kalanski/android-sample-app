package com.github.piotrkalanski.ui.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.piotrkalanski.R;
import com.github.piotrkalanski.model.Event;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import static com.github.piotrkalanski.ui.event.EventActivity.KEY_EVENT;

public class EventPlaybackActivity extends AppCompatActivity {

    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_playback);

        event = (Event)getIntent().getExtras().get(KEY_EVENT);

        ((TextView)findViewById(R.id.title)).setText(event.getTitle());
        ((TextView)findViewById(R.id.time)).setText(event.getTime());

        // TODO - don't hardcode this
        String mediaUri = "https://bitdash-a.akamaihd.net/content/MI201109210084_1/m3u8s/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.m3u8";
        SimpleExoPlayer player = new SimpleExoPlayer.Builder(this).build();
        player.setMediaItem(MediaItem.fromUri(mediaUri));
        player.prepare();
        PlayerView playerView = findViewById(R.id.video_view);
        playerView.setPlayer(player);
    }
}