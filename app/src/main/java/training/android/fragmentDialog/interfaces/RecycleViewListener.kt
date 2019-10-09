package training.android.fragmentDialog.interfaces

import android.view.View

interface RecycleViewListener {
	fun onCardViewClick(view: View)
	fun onIconClick(view: View)
	fun onLongClick(view: View)
	fun onTextClick(view: View)
}