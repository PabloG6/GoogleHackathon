package momocorp.gotchu.Services;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import momocorp.gotchu.DataStructures.RegistrationInfo;
import momocorp.gotchu.DrinkSelectionActivity;
import momocorp.gotchu.R;

/**
 * Created by Pablo on 10/30/2016.
 */
public class DrunkService extends Service {
    Handler handler;
    public static boolean clicked;
    public static int clickedTimes;


  BroadcastReceiver addValue = new BroadcastReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {

      }
  };
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
                if (!clicked){
                    clickedTimes++;

                }
                else {
                    if (clickedTimes>=3){
                        sendSMSMessage();
                    }
                }
            }
        }, 6000);


        return Service.START_STICKY;

    }

    private void showNotification(){

        //set up pending intent to start activity
        //// TODO: 8/2/2016 modify activity to show user information about driver location
        Intent addNotif = new Intent(this, NotificationService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 1, addNotif, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this).
                setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Hey Gotchu Here!")
                .setContentText("Have you had any drinks since last")
                //// TODO: 8/10/2016 fix priorities for release
                .setContentIntent(pendingIntent).setPriority(Notification.PRIORITY_MAX).
                        setDefaults(Notification.DEFAULT_VIBRATE).
                        addAction(new NotificationCompat.Action(R.drawable.ic_add_circle_teal_600_36dp, "Add", pendingIntent));
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        Notification notify = notificationBuilder.build();
        notificationManager.notify(0, notify);

    }

   public static class NotificationService extends IntentService{

        public NotificationService(String name) {
            super(name);
        }

        @Override
        protected void onHandleIntent(Intent intent) {
            String action = intent.getAction();
            if (action=="Add"){
                clicked=true;

            }

        }
    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        SharedPreferences share = this.getSharedPreferences(RegistrationInfo.REG_INFO, Context.MODE_PRIVATE);
        String phoneNo = share.getString(RegistrationInfo.EMERGENCY_PHONE_NUM, "929-350-7518");
        String message = "Hey you're friend might be sick I think you should go pick him up";

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
