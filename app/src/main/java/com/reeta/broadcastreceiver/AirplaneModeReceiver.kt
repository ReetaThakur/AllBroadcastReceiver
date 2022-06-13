package com.reeta.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        var name= intent?.getStringExtra("name")
        Toast.makeText(context, "Hey Airplane Mode on $name", Toast.LENGTH_SHORT).show()
    }
}