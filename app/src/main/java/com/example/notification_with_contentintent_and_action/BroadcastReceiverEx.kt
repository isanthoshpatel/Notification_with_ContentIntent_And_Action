package com.example.notification_with_contentintent_and_action

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastReceiverEx :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        var cText = intent!!.getStringExtra("cText")
        Toast.makeText(context,cText,Toast.LENGTH_LONG).show()

    }
}