package com.hsd.rxjavatest;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ImageView mIamge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.build();
        mIamge = (ImageView) findViewById(R.id.image);



    }


    public void view(View v) {

//        图片显示
        final int drawResource=R.mipmap.ic_launcher;
        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void subscribe(ObservableEmitter<Drawable> e) throws Exception {
                Drawable drawable = getTheme().getDrawable(drawResource);
                e.onNext(drawable);
                e.onComplete();

            }
        }).subscribe(new Observer<Drawable>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Drawable value) {
                mIamge.setImageDrawable(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

//        数据的循环打印
//        String names[]={"xiaoming","xiaohong","xiaozhang"};
//
//        Observable.fromArray(names)
//                .subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.d("accept",s);
//            }
//        });
//        简单实现
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("HELLO");
//            }
//        }).subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.io())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d("onSubscribe","onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(String value) {
//                        Log.d("onNext",value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d("onComplete","onComplete");
//                    }
//                });
    }
}
