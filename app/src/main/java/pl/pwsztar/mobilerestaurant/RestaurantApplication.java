package pl.pwsztar.mobilerestaurant;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class RestaurantApplication extends MultiDexApplication {

    private Scheduler scheduler;

    private static RestaurantApplication get(Context context) {
        return (RestaurantApplication) context.getApplicationContext();
    }

    public static RestaurantApplication create(Context context) {
        return RestaurantApplication.get(context);
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }
        return scheduler;
    }
}
