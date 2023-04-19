package com.nik.geoquiz;

public class Question {
    private int mTextResId;
    private boolean mAnswerTRue;

    public int getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public boolean ismAnswerTRue() {
        return mAnswerTRue;
    }

    public void setmAnswerTRue(boolean mAnswerTRue) {
        this.mAnswerTRue = mAnswerTRue;
    }

    public Question(int textResId, boolean answerTRue){
        mTextResId = textResId;
        mAnswerTRue = answerTRue;


    }
}
