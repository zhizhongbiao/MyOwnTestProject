package com.example.yang.myapplication.base.mvp;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.yang.myapplication.base.mvp.manager.CacheManager;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.store.PersistentCookieStore;


public class MainApplication extends Application {
    public static final String MAIN_PREFERENCE = "INFO_PREFERENCE";
    public SharedPreferences mainPreferences;
    //主线程handler
    private static Handler mMainThreadHandler = new Handler();
    //主线程
    private static Thread mMainThread = Thread.currentThread();
    //主线程Id
    private static int mMainThreadId = android.os.Process.myTid();
    //context
    private static MainApplication instance;
    //内存检测watcher
//    private RefWatcher refWatcher;
    private boolean isLogin;
    public static final String CART_NUM = "CART_NUM";
    public static final String VALET_CART_NUM = "VALET_CART_NUM";
//    public LocationService locationService;

    //    PatchManager patchManager;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        CacheManager.openCache(getInstance(), "data");

//        refWatcher = LeakCanary.install(this);
//        CrashReport.initCrashReport(this, "f66cd55ecc", false);
        mainPreferences = getSharedPreferences(MAIN_PREFERENCE, MODE_PRIVATE);
//        BlockCanary.install(this, new AppBlockCanaryContext()).start();

        OkGo.init(this);
        try {
            OkGo.getInstance()
                    //打开该调试开关,控制台会使用 红色error 级别打印log,并不是错误,是为了显眼,不需要就不要加入该行
                    .debug("OkHttpUtils")
                    .setCookieStore(new PersistentCookieStore());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        SDKInitializer.initialize(this);
//        locationService = new LocationService(getApplicationContext());
//        PlatformConfig.setWeixin("wx9b0e2381a696668d", "32fd4bbbb1a6d4da4c71516615d7470d");
//        PlatformConfig.setQQZone("1106152416", "BJ6Y6CuIw74E4JDW");
//        UMShareAPI.get(this);
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    public static MainApplication getInstance() {
        return instance;
    }

    public static SharedPreferences getMainPreferences() {
        return getInstance().mainPreferences;
    }

/*    public static RefWatcher getRefWatcher() {
        MainApplication application = (MainApplication) MainApplication.getInstance();
        return application.refWatcher;
    }*/

}
