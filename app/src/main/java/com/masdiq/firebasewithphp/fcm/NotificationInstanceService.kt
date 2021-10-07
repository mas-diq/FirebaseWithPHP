package com.masdiq.firebasewithphp.fcm

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class NotificationInstanceService : FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        super.onTokenRefresh()
        // get token
        val refreshToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Refresh token $refreshToken")
    }
}