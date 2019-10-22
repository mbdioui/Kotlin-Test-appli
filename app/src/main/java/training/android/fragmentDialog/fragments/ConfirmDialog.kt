package training.android.fragmentDialog.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import training.android.fragmentDialog.R
import training.android.fragmentDialog.Settings
import training.android.fragmentDialog.interfaces.DialogFragmentInterface

class ConfirmDialog : DialogFragment() {

	val TAG = ConfirmDialog::class.simpleName
	var confirmDialogListener: DialogFragmentInterface? = null
	var sharedPreferences: Settings? = null

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
		sharedPreferences = Settings(activity)
		val builder = AlertDialog.Builder(
			activity,
			if (sharedPreferences!!.getNightMode()) R.style.MyDialogNight else R.style.MyDialogDefault
		)
		builder
			.setTitle("Please confirm your response")
			.setMessage("Do you confirm that you did understantd the topic")
			.setPositiveButton("confirm", DialogInterface.OnClickListener { _, _ ->
				Log.i(TAG, "confirm success")
				confirmDialogListener?.positiveResponse()
			})
			.setNegativeButton("Decline", DialogInterface.OnClickListener { _, _ ->
				Log.i(TAG, "decline success")
				confirmDialogListener?.negativeReponse()
			})
		return builder.create()
	}
}
