package training.android.fragmentDialog.interfaces.impl

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import training.android.fragmentDialog.activities.NoteDetailActivity
import training.android.fragmentDialog.model.Note

class NoteClickListenerImpl(
	var activity: AppCompatActivity,
	var notes: List<Note>
) : View.OnClickListener {

	override fun onClick(v: View?) {
		if (v!!.tag != null) {
			Toast.makeText(activity, "element clicked is ${v.tag}", Toast.LENGTH_SHORT).show()
			lunchDetailNote(v)
		}

	}

	private fun lunchDetailNote(v: View) {
		val detail_note_intent = Intent(activity, NoteDetailActivity::class.java)
		detail_note_intent.putExtra(NoteDetailActivity.EXTRA_NOTE, notes[v.tag as Int])
		detail_note_intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, v.tag as Int)
		activity.startActivityForResult(detail_note_intent, NoteDetailActivity.EDIT_NOTE_REQUEST)
	}

}
