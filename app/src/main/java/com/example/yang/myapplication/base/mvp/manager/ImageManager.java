package com.example.yang.myapplication.base.mvp.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.yang.myapplication.base.mvp.network.ApiConfig;


/**
 * Author : WaterFlower.
 * Created on 2017/8/11.
 * Desc :  本地及远程服务器的图片管理
 */


public class ImageManager {

    private static ImageManager instance;

    private ImageManager() {

    }

    public static ImageManager getDefault() {
        if (instance == null) {
            synchronized (ImageManager.class) {
                instance = new ImageManager();
            }

            return instance;
        }
        return instance;
    }

    /*
        加载指定URL的图片并设置到targetView
     */
    public static void loadNoDefaultImage(Context context, String url, ImageView targetView) {
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(targetView);
    }

    /*
        加载指定URL的图片并设置到targetView
     */
    public static void load(Context context, String url, ImageView targetView) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (!url.startsWith("http")) {
            url = ApiConfig.HOST + url;
        }

        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(targetView);
    }


    /*
        加载指定URL的图片并设置到targetView
     */
    public static void load(Context context, String url, final View targetView) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (!url.startsWith("http")) {
            url = ApiConfig.HOST + url;
        }

        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                if (targetView instanceof ImageView) {
                    ((ImageView) targetView).setImageDrawable(resource);
                } else {
                    targetView.setBackgroundDrawable(resource);
                }
            }
        });
    }

    /*
        加载指定URL的图片并设置到targetView
     */
    public static void loadAsBitMap(Context context, String url, ImageView targetView) {
//        targetView.setImageResource(R.drawable.place_holer_rect);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (!url.startsWith("http")) {
            url = ApiConfig.HOST + url;
        }
        Glide.with(context).load(url).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(targetView);
    }

    /*
         初始化占位图，加载指定URL的图片并设置到targetView
      */
    public static void loadBitmap(Context context, String url, int placeHolder, ImageView targetView) {
        targetView.setImageResource(placeHolder);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (!url.startsWith("http")) {
            url = ApiConfig.HOST + url;
        }
        Glide.with(context).load(url).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(placeHolder).into(targetView);
    }

    /*
      初始化占位图，加载指定URL的图片并设置到targetView
   */
    public static void load(Context context, String url, int placeHolder, ImageView targetView) {
        targetView.setImageResource(placeHolder);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (!url.startsWith("http")) {
            url = ApiConfig.HOST + url;
        }
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(placeHolder).into(targetView);
    }

    /*
      初始化占位图，加载指定URL的图片并设置到targetView
   */
    public static void load(Context context, String url, Drawable placeHolder, ImageView targetView) {
        targetView.setImageDrawable(placeHolder);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (!url.startsWith("http")) {
            url = ApiConfig.HOST + url;
        }
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(placeHolder).into(targetView);
    }


    public static void load(Context context, ImageView view, String url) {
        if (!url.startsWith("http")) {
            if (url.startsWith("/")) {
                url = url.substring(1, url.length());
            }
            url = ApiConfig.HOST + url;
        }
        Glide.with(context).load(url).into(view);
    }
}
