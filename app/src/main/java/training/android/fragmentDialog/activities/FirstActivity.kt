package training.android.fragmentDialog.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.common_activity_layout.*
import training.android.fragmentDialog.R
import training.android.fragmentDialog.fragments.ConfirmDialog
import training.android.fragmentDialog.interfaces.impl.ConfirmDialogImpl

class FirstActivity : CommonActivity() {
	lateinit var mContext: Activity

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		mContext=this
		setSupportActionBar(default_toolbar)
		textView.setOnClickListener { showdialog() }
		btn_view_notes.setOnClickListener { showNotes() }
	}

	private fun showNotes() {
		Intent(this, NoteListActivity::class.java).run {
			startActivity(this)
		}
	}

	override fun onRestart() {
		super.onRestart()
		restartActivity()
	}

	private fun showdialog() {
		val confirmDialog = ConfirmDialog()
		confirmDialog.show(fragmentManager, "confirm dialog secondDialogFragment")
		confirmDialog.apply {
			confirmDialogListener = ConfirmDialogImpl(mContext,mContext.fragmentManager	)
		}
	}

}

