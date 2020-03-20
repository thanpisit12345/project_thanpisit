package com.example.project_final

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class MainActivity : AppCompatActivity() {
    val login = login()
    val manager = supportFragmentManager
    val transaction = manager.beginTransaction()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        debugHashKey()
        setContentView(R.layout.activity_main)
        transaction.replace(R.id.layout, login,"fragment_login")
        transaction.addToBackStack("fragment_login")
        transaction.commit()
    }

    private fun debugHashKey() {
        try {
            val info = packageManager.getPackageInfo(
                "com.example.project_final",
                PackageManager.GET_SIGNATURES
            )
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", Base64.getEncoder().encodeToString(md.digest()))
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) {
        }
    }
}
