package com.example.lekcja10_koszykowka;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PunktyViewModel extends ViewModel {

    private MutableLiveData<Integer> punktyA;
    private MutableLiveData<Integer> punktyB;

    public MutableLiveData<Integer> getPunktyA() {
        if (punktyA == null) {
            punktyA = new MutableLiveData<>();
            punktyA.setValue(0);
        }
        return punktyA;
    }

    public MutableLiveData<Integer> getPunktyB() {
        if (punktyB == null) {
            punktyB = new MutableLiveData<>();
            punktyB.setValue(0);
        }
        return punktyB;
    }

    public void addPunktyA(int p) {
        if (punktyA == null) {
            punktyA = new MutableLiveData<>();
            punktyA.setValue(0);
        }
        Integer aktualne = punktyA.getValue();
        if (aktualne == null) aktualne = 0;
        punktyA.setValue(aktualne + p);
    }

    public void addPunktyB(int p) {
        if (punktyB == null) {
            punktyB = new MutableLiveData<>();
            punktyB.setValue(0);
        }
        Integer aktualne = punktyB.getValue();
        if (aktualne == null) aktualne = 0;
        punktyB.setValue(aktualne + p);
    }

    public void resetA() {
        if (punktyA == null) punktyA = new MutableLiveData<>();
        punktyA.setValue(0);
    }

    public void resetB() {
        if (punktyB == null) punktyB = new MutableLiveData<>();
        punktyB.setValue(0);
    }

}