package training.android.fragmentDialog.interfaces.impl

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import training.android.fragmentDialog.activities.NoteDetailActivity
import training.android.fragmentDialog.model.Note

class NoteClickListenerImpl(
	var activity: Context,
	var notes: List<Note>
) : View.OnClickListener {

	override fun onClick(v: View?) {
		if (v!!.tag != null) {
			Toast.makeText(activity, "element clicked is ${v.tag}", Toast.LENGTH_SHORT).show()
			lunchDetailNote(v)
		}

	}

	private fun lunchDetailNote(v: View) {
		val detail_note_intent: Intent = Intent(activity, NoteDetailActivity::class.java)
		detail_note_intent.putExtra(NoteDetailActivity.EXTRA_NOTE, notes[v.tag as Int])
		detail_note_intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, v.tag as Int)
		activity.startActivity(detail_note_intent)
	}

}
