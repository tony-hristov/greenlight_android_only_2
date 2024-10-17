import android.util.Log
import me.greenlight.partner.GreenlightSDKEventListener
import me.greenlight.partner.events.GreenlightSDKEvent

/**
 * Alkami implementation of [GreenlightSDKEventListener]. Listens for [GreenlightSDKEvent] events
 * and sends to the Flutter method channel
 */
class AlkamiGreenlightEventListener() : GreenlightSDKEventListener {
    /** onEvent handler for [GreenlightSDKEvent]. Sends the event to the Flutter method channel */
    override fun onEvent(event: GreenlightSDKEvent) {
        when (event) {
            GreenlightSDKEvent.SendMoney -> {
                Log.d("Greenlight", "Event received: sendMoney")
            }
            GreenlightSDKEvent.UserInteraction -> {
                Log.d("Greenlight", "Event received: userInteraction")
            }
        }
    }

}
