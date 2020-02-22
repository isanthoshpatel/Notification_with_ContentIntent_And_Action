package com.example.notification_with_contentintent_and_action

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class App : Application(){
companion object {
    var id1 = "channel1"
}
    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            var nch1 = NotificationChannel(id1,"channel1",NotificationManager.IMPORTANCE_HIGH)
            nch1.description = "from this channel notifications make sound and pop on screen"

            var nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(nch1)
        }


    }
}