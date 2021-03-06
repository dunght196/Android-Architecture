package com.example.viewmodelsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public class CountNumerViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> mScoreTeamA = new MutableLiveData<>();
    private MutableLiveData<Integer> mScoreTeamB = new MutableLiveData<>();

    public CountNumerViewModel(@NonNull Application application) {
        super(application);
        mScoreTeamA.setValue(0);
        mScoreTeamB.setValue(0);
    }

    public MutableLiveData<Integer> getScoreTeamA() {
        return mScoreTeamA;
    }

    public MutableLiveData<Integer> getScoreTeamB() {
        return mScoreTeamB;
    }

    public void increaseScoreTeamA(int score) {
        mScoreTeamA.setValue(mScoreTeamA.getValue() + score);
    }

    public void increaseScoreTeamB(int score) {
        mScoreTeamB.setValue(mScoreTeamB.getValue() + score);
    }


}
