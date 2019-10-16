package training.android.fragmentDialog.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.common_activity_layout.*
import kotlinx.android.synthetic.main.note_list_layout.*
import training.android.fragmentDialog.R
import training.android.fragmentDialog.adapter.NoteAdapter
import training.android.fragmentDialog.model.Note

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
		val detail_note_intent = Intent(this, NoteDetailActivity::class.java)

		detail_note_intent.putExtra(
			NoteDetailActivity.EXTRA_NOTE,
			if (index >= 0) notes[index] else Note()
		)
		detail_note_intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, index)
		startActivityForResult(
			detail_note_intent,
			NoteDetailActivity.EDIT_NOTE_REQUEST
		)
	}

	private fun fabEvent() {
		fab_note.setOnClickListener {
			showNote(-1)
		}
	}

	private fun initListStaticValues() {
		notes = mutableListOf()
		notes.add(Note("Note1", "this is a pure exemple of obselete text"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Bob", "Nice player"))
		notes.add(Note("salah mejri", "fierté tunisienne"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note2", "Note about 2"))
		notes.add(Note("Note3", "Note about 3"))
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
				saveNote(data)
			}
		}
	}

	private fun saveNote(data: Intent) {
		val note = data.getParcelableExtra<Note>(NoteDetailActivity.EXTRA_NOTE)
		val noteIndex: Int = data.getIntExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, -1)
		if (noteIndex >= 0)
			notes[noteIndex] = note
		else
			notes.add(0, note)
		noteAdapter.notifyDataSetChanged()
	}
}