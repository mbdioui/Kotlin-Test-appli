package training.android.fragmentDialog

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class Settings(context: Context) {
	var sharedPreference: SharedPreferences? = null

	init {
		sharedPreference = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
	}

	fun setNightMode(bool: Boolean) {
		val editor: SharedPreferences.Editor = sharedPreference!!.edit()
		editor.putBoolean("NightMode", bool)
		editor.commit()
	}

	fun getNightMode(): Boolean {
		return sharedPreference!!.getBoolean("NightMode", false)
	}

	companion object Setter {
		fun setAppTheme(activity: Activity, nightMode: Boolean) {
			if (nightMode)
				activity.setTheme(R.style.AppThemeNight)
			else
				activity.setTheme(R.style.AppThemeLight)
		}

	}
}