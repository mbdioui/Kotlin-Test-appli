package training.android.fragmentDialog.fragments

import android.app.*
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import training.android.fragmentDialog.R
import training.android.fragmentDialog.Settings
import training.android.fragmentDialog.interfaces.DialogFragmentInterface

public class ListDialog : DialogFragment() {

	val TAG = ListDialog::class.simpleName
	var listDialogListener: DialogFragmentInterface? = null
	var sharedPreferences: Settings? = null

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
		sharedPreferences = Settings(activity)
		val builder = AlertDialog.Builder(
			activity,
			if (sharedPreferences!!.getNightMode()) R.style.MyDialogNight else R.style.MyDialogDefault
		)
		val inflater = activity.layoutInflater

		builder

			.setView(inflater.inflate(R.layout.default_list_layout, null))
			.setTitle("Please confirm your response")
			.setMessage("Do you confirm that you did understantd the topic")
			.setPositiveButton("confirm", DialogInterface.OnClickListener { _, _ ->
				Log.i(TAG, "confirm success")
				listDialogListener?.positiveResponse()
			})
			.setNegativeButton("Decline", DialogInterface.OnClickListener { _, _ ->
				Log.i(TAG, "decline success")
				listDialogListener?.negativeReponse()
			})
		return builder.create()
	}
}
