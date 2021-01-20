package com.example.daggertest.recyclerview;

/**
 * Created by BaNguyen on 8/4/2016.
 * 11:38 AM
 */
interface OnBottomListener {
    void onBottom();

    void onScroll(int firstVisible, int lastVisible, int dx, int dy);

    void onShow();

    void onHide();
}
