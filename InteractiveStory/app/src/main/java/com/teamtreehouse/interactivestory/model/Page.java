package com.teamtreehouse.interactivestory.model;

/**
 * Created by plamen on 1/24/16.
 */
public class Page {
    private int mImageId;
    private String mText;
    private Choice mChoiceA;
    private Choice mChoiceB;

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoiceA() {
        return mChoiceA;
    }

    public void setChoiceA(Choice choiceA) {
        mChoiceA = choiceA;
    }

    public Choice getChoiceB() {
        return mChoiceB;
    }

    public void setChoiceB(Choice choiceB) {
        mChoiceB = choiceB;
    }
}
