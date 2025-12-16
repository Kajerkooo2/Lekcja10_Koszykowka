package com.example.lekcja10_koszykowka;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PunktyViewModel extends ViewModel {

    private MutableLiveData<Integer> punkty;

    public MutableLiveData<Integer> getPunkty() {
        if(punkty == null){
            punkty = new MutableLiveData<>();
            punkty.setValue(0);
        }
        return punkty;
    }

    public void setPunkty(MutableLiveData<Integer> punkty) {
        if(punkty == null){
            punkty = new MutableLiveData<>();
        }
        this.punkty = punkty;
    }

    public void addPunkty(int p){
        if(punkty == null){
            punkty = new MutableLiveData<>();
            punkty.setValue(0);
        }
        int aktualne_punkty = punkty.getValue();
        punkty.setValue(aktualne_punkty+p);
    }
}
