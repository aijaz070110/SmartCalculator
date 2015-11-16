package com.samatfunstudios.smartcalculator;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by dell on 11/7/2015.
 */
public class AudioPlayer
{
    String fileName;
    Context contex;
    MediaPlayer mp;

    //Constructor
    public AudioPlayer( Context context) {

        contex = context;
//        playAudio();
    }

    //Play Audio
    public void playAudio(String name) {
        fileName = name;
        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            AssetFileDescriptor descriptor = contex.getAssets()
                    .openFd(fileName);

            mp.setDataSource(descriptor.getFileDescriptor(),
                    descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();
            mp.prepare();
//            mp.setLooping(false);
            mp.start();   // mp.release();

            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
            mp.setVolume(3, 3);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void stop() {
        mp.stop();
    }

}
