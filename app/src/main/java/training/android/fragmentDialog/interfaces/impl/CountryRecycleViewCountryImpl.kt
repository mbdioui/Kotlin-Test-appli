package training.android.fragmentDialog.interfaces.impl

import android.content.Context
import android.view.View
import android.widget.Toast
import training.android.fragmentDialog.interfaces.CountryRecycleViewListener

class CountryRecycleViewCountryImpl(val context: Context) : CountryRecycleViewListener {
	override fun onCardViewClick(view: View) {
		Toast.makeText(
			context,
			"hello thank you for typing on cardview item ${view.tag}",
			Toast.LENGTH_SHORT
		)
			.show()
	}

	override fun onIconClick(view: View) {
		Toast.makeText(context, "hello thank you for typing on Icon item", Toast.LENGTH_SHORT)
			.show()
	}

	override fun onLongClick(view: View) {
		Toast.makeText(context, "hello thank you for typing long click on card", Toast.LENGTH_SHORT)
			.show()
	}

	override fun onTextClick(view: View) {
		Toast.makeText(context, "hello thank you for typing on text item", Toast.LENGTH_SHORT)
			.show()
	}
}