package training.android.fragmentDialog.interfaces.impl

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import training.android.fragmentDialog.activities.SecondActivity
import training.android.fragmentDialog.interfaces.DialogFragmentInterface

class DialogListenerImpl(context: Context) :
	DialogFragmentInterface {

	val context = context
	override fun negativeReponse() {
		Toast(context).showText(context, "not able to redirect you")
	}

	override fun positiveResponse() {
		Intent(
			context,
			SecondActivity::class.java
		).run {
			startActivity(context, this, null)
		}
	}

}
