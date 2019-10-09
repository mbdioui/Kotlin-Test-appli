package training.android.fragmentDialog.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import training.android.fragmentDialog.R
import training.android.fragmentDialog.Settings

open class CommonActivity : AppCompatActivity() {
	var sharedpreference: Settings? = null
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
		val i = Intent(this, this::class.java)
		startActivity(i)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.toolbar_main_menu, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.action_send -> {
				Toast.makeText(this, "yessss secondActivityIntent's sended", Toast.LENGTH_SHORT)
					.show()
			}

			R.id.action_delete -> {
				Toast.makeText(this, "yessss secondActivityIntent's deleted", Toast.LENGTH_SHORT)
					.show()
			}
		}
		return true
	}

}