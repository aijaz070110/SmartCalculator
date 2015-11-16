package com.samatfunstudios.smartcalculator;

import android.app.Activity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


/**
 * Created by root on 09/11/15.
 */
public class ShowAdUtil {

    private InterstitialAd mInterstitialAd;

    Activity activity;
    public ShowAdUtil(Activity activity)
    {
        this.activity = activity;
    }

     public void creatInterstitialAdd()
    {
        mInterstitialAd = new InterstitialAd(activity);
        mInterstitialAd.setAdUnitId(activity.getResources().getString(com.samatfunstudios.smartcalculator.R.string.interestitial));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
//                mNextLevelButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
//                mNextLevelButton.setEnabled(true);
//                finish();
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
//                goToNextLevel();
//                finish();
            }
        });

        loadInterstitial();
    }
    private void loadInterstitial() {
        // Disable the next level button and load the ad.
        AdRequest adRequest = new AdRequest.Builder().build();

//        AdRequest adRequest   =AdRequest.Builder.addTestDevice("81055A545D14EE9FFDDF3A3FF4735F1A").build();
        mInterstitialAd.loadAd(adRequest);
    }


    public void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
//            finish();
//            Toast.makeText(this,"Add not loaded",Toast.LENGTH_SHORT).show();

        }
    }
}
