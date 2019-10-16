package training.android.fragmentDialog.interfaces.impl

import android.content.Intent
import android.os.Parcelable
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
			lunchDetailNote(v.tag as Int)
		}

	}

	private fun lunchDetailNote(index: Int) {
		val detail_note_intent = Intent(activity, NoteDetailActivity::class.java)
		detail_note_intent.putExtra(NoteDetailActivity.EXTRA_NOTE, notes[index] as Parcelable)
		detail_note_intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, index)
		activity.startActivityForResult(detail_note_intent, NoteDetailActivity.EDIT_NOTE_REQUEST)
	}

}
