package training.android.fragmentDialog.interfaces.impl

import android.app.FragmentManager
import android.content.Context
import android.widget.Toast
import training.android.fragmentDialog.fragments.ListDialog
import training.android.fragmentDialog.interfaces.DialogFragmentInterface

class ConfirmDialogImpl(
	context: Context,
	fragmentManager: FragmentManager
) : DialogFragmentInterface {

	val context = context
	val secondDialogFragment = ListDialog()
	val fManger = fragmentManager
	override fun positiveResponse() {

		Toast.makeText(
			context,
			"positif click dialog Firt DialogFragment",
			Toast.LENGTH_SHORT
		)
			.show()
		secondDialogFragment.show(fManger, "second secondDialogFragment")
		secondDialogFragment.listDialogListener =
			DialogListenerImpl(context)
	}


	override fun negativeReponse() {
		Toast.makeText(
			context,
			"negatif click dialog First DialogFragment",
			Toast.LENGTH_SHORT
		)
			.show()
	}
}
