import android.util.Log
import com.example.greenlight_android_only.Constants
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlinx.coroutines.*
import me.greenlight.partner.authentication.GreenlightSDKAuthentication
import me.greenlight.partner.authentication.TokenData

/**
 * Alkami implementation of [GreenlightSDKAuthentication]. Provides a callback for fetching user
 * token from the Flutter method channel
 */
class AlkamiGreenlightAuthenticator() : GreenlightSDKAuthentication {
    /** Calls method "fetchNewToken" on the Flutter method channel to fetch user token */
    override suspend fun fetchNewToken(): TokenData {
        return suspendCoroutine { continuation ->
            continuation.resume(
                TokenData(
                    accessToken = Constants.TOKEN_VALUE,
                    expiresIn = Constants.TOKEN_EXPIRES,
                    tokenType =Constants.TOKEN_TYPE,
                )
            )
        }
    }
}
