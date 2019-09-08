package com.example.rx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Operator
 */
public class Example2Activity extends AppCompatActivity {

    private static final String TAG = Example2Activity.class.getSimpleName();

    private Disposable disposable; // Unsubscrible observer vs observable khi Activity/Fragment bị destroy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        // Observable
        Observable<String> footballPlayersObservable = getFootballPlayersObservable();

        // Observer
        Observer<String> footballPlayerObserver = getFootballPlayersObserver();

        // Subscription
        footballPlayersObservable
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.toLowerCase().startsWith("m");
                    }
                })
                .subscribe(footballPlayerObserver);

    }

    private Observer<String> getFootballPlayersObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscibe");
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG,"Name: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "All items are emiited!");
            }
        };
    }

    private Observable<String> getFootballPlayersObservable() {
        return Observable.just("Messi", "Ronaldo", "Modric", "Salah", "Mbappe");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
