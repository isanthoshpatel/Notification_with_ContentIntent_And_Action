package com.example.notification_with_contentintent_and_action

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bt1.setOnClickListener {

            var i1 = Intent(this, MainActivity::class.java)
            var pi1 = PendingIntent.getActivity(this, 0, i1, 0)

            var i2 = Intent(this, BroadcastReceiverEx::class.java)
            i2.putExtra("cText", et2.text.toString())
            var pi2 = PendingIntent.getBroadcast(this, 0, i2, PendingIntent.FLAG_UPDATE_CURRENT)

            var n1 = NotificationCompat.Builder(this, App.id1)
                .setSmallIcon(R.drawable.android)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.android))
                //
                .setContentTitle(et1.text.toString())
                .setContentText(et2.text.toString())
                //
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                //
                .setOnlyAlertOnce(true)
                //
                .setColor(Color.RED)
                //
                .setContentIntent(pi1)
                .setAutoCancel(true)
                //
                .addAction(R.drawable.android, "Toast", pi2)
                .build()

            var nm = NotificationManagerCompat.from(this)
            nm.notify(i++, n1)

        }


    }
}
