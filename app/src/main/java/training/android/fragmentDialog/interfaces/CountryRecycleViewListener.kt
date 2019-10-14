package training.android.fragmentDialog.interfaces

import android.view.View

interface CountryRecycleViewListener {
	fun onCardViewClick(view: View)
	fun onIconClick(view: View)
	fun onLongClick(view: View)
	fun onTextClick(view: View)
}