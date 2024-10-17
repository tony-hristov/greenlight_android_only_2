package com.example.greenlight_android_only

import AlkamiGreenlightAuthenticator
import AlkamiGreenlightErrorListener
import AlkamiGreenlightEventListener
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import me.greenlight.partner.GreenlightSDK
import me.greenlight.partner.GreenlightSDKConfiguration
import me.greenlight.partner.GreenlightSDKEnvironment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLaunchSdk = findViewById<Button>(R.id.btnLaunchSdk);
        btnLaunchSdk.setOnClickListener {
            val configuration =
                GreenlightSDKConfiguration(
                    environment =
                    if (Constants.IS_PRODUCTION) GreenlightSDKEnvironment.Production
                    else GreenlightSDKEnvironment.Staging,
                    authentication = AlkamiGreenlightAuthenticator(),
                    errorListener = AlkamiGreenlightErrorListener(),
                    eventListener = AlkamiGreenlightEventListener(),
                )
            GreenlightSDK.init(configuration, context = applicationContext)
            GreenlightSDK.launchChildDashboard(this, Constants.FAMILY_ID, Constants.CHILD_ID)
        }
    }
}