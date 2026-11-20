package app.gamenative.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * PocketRig: hands a Steam game to DroidDeck (github.com/Droid-Deck/DroidDeck), which runs Valve's
 * real Steam client with Big Picture, Steam Input, Steam Cloud and achievements.
 * DroidDeck opens links of the form droiddeck://game/<Steam app ID>.
 */
object DroidDeckLink {
    fun intentFor(steamAppId: Int): Intent =
        Intent(Intent.ACTION_VIEW, Uri.parse("droiddeck://game/$steamAppId"))
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

    /** True when some installed app (DroidDeck, under any of its package names) opens these links. */
    fun isInstalled(context: Context): Boolean =
        intentFor(1).resolveActivity(context.packageManager) != null
}
