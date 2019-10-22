package training.android.fragmentDialog.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import training.android.fragmentDialog.R
import training.android.fragmentDialog.Settings

open class CommonActivity : AppCompatActivity() {
	lateinit var sharedpreference: Settings
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		sharedpreference = Settings(this)
		Settings.setAppTheme(
			this,
			sharedpreference!!.getNightMode()
		)
	}

	protected fun restartActivity() {
		this.finish()
		run {
			var i = Intent(this, this::class.java)
			startActivity(i)
		}
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.toolbar_main_menu, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.action_send -> {
				Toast.makeText(this, "yessss item's sended", Toast.LENGTH_SHORT)
					.show()
			}

			R.id.action_delete -> {
				Toast.makeText(this, "yessss item's deleted", Toast.LENGTH_SHORT)
					.show()
			}

			android.R.id.home ->
				NavUtils.navigateUpFromSameTask(this)
		}
		return true
	}
}