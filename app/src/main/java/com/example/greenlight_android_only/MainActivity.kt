package com.example.greenlight_android_only

import AlkamiGreenlightAuthenticator
import AlkamiGreenlightErrorListener
import AlkamiGreenlightEventListener
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import me.greenlight.partner.GreenlightSDK
import me.greenlight.partner.GreenlightSDKConfiguration
import me.greenlight.partner.GreenlightSDKEnvironment
import me.greenlight.partner.theming.GreenlightSDKColors
import me.greenlight.partner.theming.GreenlightSDKComposeColors
import me.greenlight.partner.theming.GreenlightSDKTheme
import me.greenlight.partner.theming.defaultGreenlightSDKLightColors
import me.greenlight.partner.theming.defaultGreenlightSDKShapes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                    theme = GreenlightSDKTheme(
                        colors = GreenlightSDKColors(
                            light = getLightThemeColors()
                        ),
                        shapes = defaultGreenlightSDKShapes(),
                    )
                )
            GreenlightSDK.init(configuration, context = applicationContext)
            GreenlightSDK.launchChildDashboard(this, Constants.FAMILY_ID, Constants.CHILD_ID)
        }
    }

    /**
     * Get all the colors from the theme data to initialize a light theme
     */
    private fun getLightThemeColors(): GreenlightSDKComposeColors {
        val defaults = defaultGreenlightSDKLightColors()
        return defaults.copy(
            // Surface colors //

            // Screen Surface colors
            screenSurface = Color(255, 250, 225, 255),
        )
    }
}