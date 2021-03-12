package com.breaktime.programmingquiz.Notifications;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.breaktime.programmingquiz.Layouts.Menu;
import com.breaktime.programmingquiz.R;

public class ShowNotifications extends Application implements Runnable {
    private String[] textNotification;
    private final NotificationManager  notificationManager;
    private final int NOTIFICATION_ID = 127;
    private final Context context;
    public ShowNotifications(Context context, NotificationManager mNotificationManager){
        this.context = context;
        notificationManager = mNotificationManager;
        textNotification = new String[]{context.getString(R.string.notification_1),
                context.getString(R.string.notification_2), context.getString(R.string.notification_3),
                context.getString(R.string.notification_4)};
    }

    @Override
    public void run() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "studentChannel";
            String description = "Channel for student notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("channel", name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
        Intent intent = new Intent(context, Menu.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.logo_break_time)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.logo))    //program logo
                .setTicker(context.getString(R.string.notification_ticker))
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentText(textNotification[(int)(Math.random() * textNotification.length)])
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        Notification notification = builder.build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
