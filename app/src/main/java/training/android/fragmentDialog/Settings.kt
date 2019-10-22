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
		sharedPreference?.edit()?.let {
			it.putBoolean("NightMode", bool)
			it.commit()
		}
	}

	fun getNightMode(): Boolean {
		return sharedPreference!!.getBoolean("NightMode", false)
	}

	companion object Setter {
		fun setAppTheme(
			activity: Activity,
			nightMode: Boolean
		) {
			if (nightMode)
				activity.setTheme(R.style.AppThemeNight)
			else
				activity.setTheme(R.style.AppThemeLight)
		}

	}
}