package training.android.fragmentDialog.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.common_activity_layout.*
import kotlinx.android.synthetic.main.note_list_layout.*
import training.android.fragmentDialog.R
import training.android.fragmentDialog.adapter.NoteAdapter
import training.android.fragmentDialog.model.Note
import training.android.fragmentDialog.utils.loadNotes
import training.android.fragmentDialog.utils.persistNote

class NoteListActivity : CommonActivity() {
	lateinit var notes: MutableList<Note>
	lateinit var noteAdapter: NoteAdapter
	lateinit var itemNoteListener: View.OnClickListener
	var recyclerview: RecyclerView? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.note_list_layout)
		setSupportActionBar(default_toolbar)
		initListStaticValues()
		fabEvent()
		itemNoteListener = View.OnClickListener { v ->
			val index = v.tag as Int
			showNote(index)
		}
		noteAdapter = NoteAdapter(notes as List<Note>, itemNoteListener)
		recyclerview = note_list
		recyclerview!!.layoutManager = LinearLayoutManager(this)
		recyclerview!!.adapter = noteAdapter
	}

	private fun showNote(index: Int) {
		val detailNoteIntent = Intent(this, NoteDetailActivity::class.java)

		detailNoteIntent.putExtra(
			NoteDetailActivity.EXTRA_NOTE,
			if (index >= 0) notes[index] as Parcelable else Note() as Parcelable
		)
		detailNoteIntent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, index)
		startActivityForResult(
			detailNoteIntent,
			NoteDetailActivity.EDIT_NOTE_REQUEST
		)
	}

	private fun fabEvent() {
		fab_note.setOnClickListener {
			showNote(-1)
		}
	}

	private fun initListStaticValues() {
		notes = loadNotes(this)
	}

	override fun onActivityResult(
		requestCode: Int,
		resultCode: Int,
		data: Intent?
	) {
		super.onActivityResult(requestCode, resultCode, data)
		if (resultCode != Activity.RESULT_OK || data == null) {
			return
		}
		when (requestCode) {
			NoteDetailActivity.EDIT_NOTE_REQUEST -> {
				processNote(data)
			}
		}
	}

	private fun processNote(data: Intent) {
		when (data.action) {
			NoteDetailActivity.ACTION_SAVE_NOTE -> saveNote(data)
			NoteDetailActivity.ACTION_DELETE_NOTE -> deleteNote(data)
		}
	}

	private fun deleteNote(data: Intent) {
		val index = data.getIntExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, -1)
		var note: Note? = null
		if (index >= 0) {
			note = notes.removeAt(index)
			training.android.fragmentDialog.utils.deleteNote(this, note)
			noteAdapter.notifyDataSetChanged()
		}
		Snackbar.make(
			coordinator_list_note,
			"note \"${note!!.title}\" deleted from list",
			Snackbar.LENGTH_SHORT
		)
			.show()
	}

	private fun saveNote(data: Intent) {
		val note = data.getParcelableExtra<Note>(NoteDetailActivity.EXTRA_NOTE)
		val noteIndex: Int = data.getIntExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, -1)
		if (noteIndex >= 0)
			notes[noteIndex] = note
		else
			notes.add(0, note)
		persistNote(this, note)
		noteAdapter.notifyDataSetChanged()
	}
}