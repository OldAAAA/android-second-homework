package com.magicwind.android.fitness_club.Network;

import android.widget.Toast;

import com.magicwind.android.fitness_club.APIServer.*;
import com.magicwind.android.fitness_club.Model.Responsebeen;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelp {
    //使用retrofit 连接服务器
    private OkHttpClient client;
    public static APIServer server;

    public static RetrofitHelp mRetrofitHip = new RetrofitHelp();

    private RetrofitHelp(){
        //这个是一个okhttp3的客户端
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        client = new OkHttpClient.Builder().addInterceptor(logging).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://123.206.79.91:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        server = retrofit.create(APIServer.class);
    }

}
