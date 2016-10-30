package momocorp.gotchu.Services;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import momocorp.gotchu.DrinkSelectionActivity;
import momocorp.gotchu.R;

/**
 * Created by Pablo on 10/30/2016.
 */
public class DrunkService extends Service {
    Handler handler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            showNotification();

            }
        }, 1000);


        return Service.START_STICKY;

    }

    private void showNotification(){

        //set up pending intent to start activity
        //// TODO: 8/2/2016 modify activity to show user information about driver location
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1,
                new Intent(this, DrinkSelectionActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        //// TODO: 8/2/2016 check if removing pending intent stops notification service
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this).
                setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Hey Gotchu Here!")
                .setContentText("How many drinks have you had since last?")
                //// TODO: 8/10/2016 fix priorities for release
                .setContentIntent(pendingIntent).setPriority(Notification.PRIORITY_MAX).setDefaults(Notification.DEFAULT_VIBRATE);

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
