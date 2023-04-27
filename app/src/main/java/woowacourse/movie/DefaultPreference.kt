package woowacourse.movie

import android.content.Context
import android.content.SharedPreferences

class DefaultPreference(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(
            "prefs_name",
            Context.MODE_PRIVATE + Context.MODE_MULTI_PROCESS
        )

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return prefs.getBoolean(key, defValue)
    }

    fun setBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }
}
