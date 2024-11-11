package com.example.tileservicelockscreenbugsample

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.service.quicksettings.TileService
import android.util.Log

class CrashingTileService : TileService() {

    override fun onTileAdded() {
        super.onTileAdded()
        Log.d("CrashingTileService", "onTileAdded()")
    }

    override fun onStartListening() {
        super.onStartListening()
        Log.d("CrashingTileService", "onStartListening()")
    }

    override fun onStopListening() {
        super.onStopListening()
        Log.d("CrashingTileService", "onStopListening()")
    }

    override fun onClick() {
        super.onClick()
        Log.d("CrashingTileService", "onClick()")
        val intent = Intent(this, MainActivity::class.java)
            .addFlags(FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    override fun onTileRemoved() {
        super.onTileRemoved()
        Log.d("CrashingTileService", "onTileRemoved()")
    }
}