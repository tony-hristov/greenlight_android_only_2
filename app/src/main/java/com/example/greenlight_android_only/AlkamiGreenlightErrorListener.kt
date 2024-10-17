import android.util.Log
import me.greenlight.partner.GreenlightSDKErrorListener

/**
 * Alkami implementation of [GreenlightSDKErrorListener]. Listens for [Throwable] errors and sends
 * to the Flutter method channel
 */
class AlkamiGreenlightErrorListener() : GreenlightSDKErrorListener {
    /** onError handler for [Throwable]. Sends the error message to the Flutter method channel */
    override fun onError(error: Throwable) {
        Log.e( "Greenlight", "Greenlight Error received: ${error.message}")
        Log.e( "Greenlight", "Greenlight Error received: ${error.printStackTrace()}")
    }
}
