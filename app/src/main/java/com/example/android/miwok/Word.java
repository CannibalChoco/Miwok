package com.example.android.miwok;

/**
 * Created by Kristine on 02.05.2017.
 *
 * Class represents a single vocabulary word - miwok, default, image
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    /**
     *  Create a new Word object instance.
     *
     *  @param defaultTranslation is the word in a language that the user is already familiar with
     *                            (such as English)
     *  @param miwokTranslation is the word in the Miwok language
     *  @param audioResourceID is the raw resource ID asociated with the word
     *
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceID;
    }

    /**
     *  Create a new Word object instance.
     *
     *  @param defaultTranslation is the word in a language that the user is already familiar with
     *                            (such as English)
     *  @param miwokTranslation is the word in the Miwok language
     *  @param imageResourceId is the drawable resource ID asociated with the word
     *  @param audioResourceID is the raw resource ID asociated with the word
     *
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId,
                int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceID;
    }

    /**
     * Gets the string value in the mMiwokTranslation.
     *
     * @return current text in the String mMiwokTranslation.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Gets the string value in the mDefaultTranslation.
     *
     * @return current text in the String mDefaultTranslation.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Gets the int value in the imageResourceId.
     *
     * @return current image resource ID.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Gets the int value in the mAudioResourceId.
     *
     * @return current audio resource ID.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
