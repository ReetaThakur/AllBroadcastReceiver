package com.reeta.broadcastreceiver

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {

    lateinit var airplaneModeReceiver:AirplaneModeReceiver
    lateinit var send:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        send=findViewById(R.id.btnSend)


        //for registing event by using dynamic broadcast or by using context
        //in this way we are recievering braodcast through our system
        airplaneModeReceiver= AirplaneModeReceiver()
        val intentFilter=IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(airplaneModeReceiver,intentFilter)

        // in this way we are giving broadcast to some activity or other android components
        //we are creating our own actions and sending that same action to that component
        val intentFilter1=IntentFilter("action.reeta")
        registerReceiver(airplaneModeReceiver,intentFilter1)
        send.setOnClickListener {
            val intent=Intent("action.reeta")
            intent.putExtra("name","reeta") // we also pass data through intent in broadcast receiver


            //for security purpose we can declare permission inside our broadcast
            sendBroadcast(intent,Manifest.permission.INTERNET)
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeReceiver)
    }
}