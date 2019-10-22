package training.android.fragmentDialog.interfaces.impl

import android.app.Activity
import android.app.FragmentManager
import android.content.Context
import android.widget.Toast
import training.android.fragmentDialog.fragments.ListDialog
import training.android.fragmentDialog.interfaces.DialogFragmentInterface

class ConfirmDialogImpl(
	val context: Activity,
	fragmentManager: FragmentManager
) : DialogFragmentInterface {

	private val secondDialogFragment = ListDialog()
	private val fManager = fragmentManager
	private val mContext = context
	override fun positiveResponse() {

		Toast(mContext).showText(mContext, "Positive click dialog First DialogFragment")
		secondDialogFragment.apply {
			show(fManager, "Second secondDialogFragment")
			listDialogListener =
				DialogListenerImpl(mContext)
		}
	}

	override fun negativeReponse() {
		Toast(mContext)
			.showText(mContext, "Negative click dialog First DialogFragment")
	}

}

fun Toast.showText(
	context: Context,
	text: String = "",
	duration: Int = Toast.LENGTH_SHORT
) {
	Toast.makeText(context, text, duration).show()
}
