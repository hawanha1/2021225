package org.haqnawaz.mclecture21notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void ShowNotification(View view) {
            // Sets an ID for the notification, so it can be updated.
            int notificationID = 1;
            String CHANNEL_ID = "my_channel_01";// The id of the channel.
            CharSequence name = getString(R.string.channel_name);// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            // Create a notification and set the notification channel.
            Notification notification = new Notification.Builder(MainActivity.this)
                    .setContentTitle("Ntification Title Message")
                    .setContentText("It is a notification that you've received new messages.")
                    .setSmallIcon(R.drawable.ic_android_pink_24dp)
                    .setChannelId(CHANNEL_ID)
                    .build();

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(mChannel);

            notificationManager.notify(1, notification);

    }