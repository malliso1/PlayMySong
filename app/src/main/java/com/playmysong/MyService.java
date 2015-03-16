package com.playmysong;

import android.app.IntentService;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

/**
 * Created by InSaYnE on 3/16/2015.
 */
public class MyService extends IntentService {

    public MyService(String name) {
        super(name);
    }
    public MyService() { super("NoName"); }
    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("The service is reached.");
        MediaPlayer mPlayer;
        mPlayer = new MediaPlayer();
        Uri myUri = Uri.parse("file:///sdcard/mySongs/fanfare.mp3");
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mPlayer.setDataSource(getApplicationContext(), myUri);
            mPlayer.prepare();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        mPlayer.start();
    }
}
