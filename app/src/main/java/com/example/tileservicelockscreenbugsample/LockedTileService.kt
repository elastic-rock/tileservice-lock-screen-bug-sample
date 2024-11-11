package com.example.tileservicelockscreenbugsample

import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Build
import android.service.quicksettings.TileService
import android.util.Log

class LockedTileService : TileService() {

    override fun onTileAdded() {
        super.onTileAdded()
        Log.d("LockedTileService", "onTileAdded()")
    }

    override fun onStartListening() {
        super.onStartListening()
        Log.d("LockedTileService", "onStartListening()")
    }

    override fun onStopListening() {
        super.onStopListening()
        Log.d("LockedTileService", "onStopListening()")
    }

    override fun onClick() {
        super.onClick()
        Log.d("LockedTileService", "onClick()")
        val intent = Intent(this, MainActivity::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            val pendingIntent = PendingIntent.getActivity(applicationContext, 1, intent, FLAG_IMMUTABLE)
            startActivityAndCollapse(pendingIntent)
        } else {
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
            startActivityAndCollapse(intent)
        }
    }

    override fun onTileRemoved() {
        super.onTileRemoved()
        Log.d("LockedTileService", "onTileRemoved()")
    }
}