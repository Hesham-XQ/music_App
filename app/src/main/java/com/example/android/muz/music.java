package com.example.android.muz;

/**
 * Created by SAMO on 3/1/2018.
 */

public class music {

    private String mSong;
    private String mArtist;
    private int mResourceId;
    private int mimgResourceId;

    public music(String Song, String Artist, int ResourceId, int imgResourceId) {

        mSong = Song;
        mArtist = Artist;
        mResourceId = ResourceId;
        mimgResourceId = imgResourceId;

    }

    public String getSong() {
        return mSong;
    }

    public String getArtist() {
        return mArtist;
    }

    public int getResourceid() {
        return mResourceId;
    }

    public int getMimgResourceId() {
        return mimgResourceId;
    }


}
