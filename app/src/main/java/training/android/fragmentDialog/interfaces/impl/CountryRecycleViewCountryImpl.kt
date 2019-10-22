package training.android.fragmentDialog.interfaces.impl

import android.content.Context
import android.view.View
import android.widget.Toast
import training.android.fragmentDialog.interfaces.CountryRecycleViewListener

class CountryRecycleViewCountryImpl(private val context: Context) : CountryRecycleViewListener {
	override fun onCardViewClick(view: View) {
		Toast(context).showText(context, "hello thank you for typing on cardview item ${view.tag}")
	}

	override fun onIconClick(view: View) {
		Toast(context).showText(context, "thank you for cliking on icon")
	}

	override fun onLongClick(view: View) {
		Toast(context).showText(context, "hello thank you for typing long click on card")
	}

	override fun onTextClick(view: View) {
		Toast(context).showText(context, "hello thank you for typing on text item")
	}
}