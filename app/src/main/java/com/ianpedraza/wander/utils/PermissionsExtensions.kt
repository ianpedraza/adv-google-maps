package com.ianpedraza.wander.utils

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

fun AppCompatActivity.areAllPermissionsGranted(permissions: Array<String>): Boolean {
    return permissions.fold(true) { value, item ->
        return if (isPermissionGranted(item)) {
            value
        } else {
            false
        }
    }
}

fun AppCompatActivity.isPermissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}
