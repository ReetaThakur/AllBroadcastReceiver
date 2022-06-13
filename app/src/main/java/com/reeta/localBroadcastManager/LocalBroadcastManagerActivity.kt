package com.reeta.localBroadcastManager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.reeta.broadcastreceiver.AirplaneModeReceiver
import com.reeta.broadcastreceiver.R
import java.lang.StringBuilder

class LocalBroadcastManagerActivity : AppCompatActivity() {

    lateinit var reciever: RecieverName
    lateinit var localSend: Button
    lateinit var recieveName: TextView
    lateinit var localBroadCastManager: LocalBroadcastManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_broadcast_manager)
        localSend = findViewById(R.id.btnLocalManager)
        recieveName = findViewById(R.id.txtName)
        reciever = RecieverName()
        localBroadCastManager = LocalBroadcastManager.getInstance(this)


        val intentFilter = IntentFilter("android.deeksha")
        localBroadCastManager.registerReceiver(reciever, intentFilter)
        localSend.setOnClickListener {
            val intent = Intent("android.deeksha")
            intent.putExtra("name", "Highest package")
            localBroadCastManager.sendBroadcast(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        localBroadCastManager.unregisterReceiver(reciever)
    }

    inner class RecieverName() : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            if (intent != null) {
                var name: String? = intent?.getStringExtra("name")
                recieveName.text = name

            }
        }
    }
}