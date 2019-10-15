package training.android.fragmentDialog.activities

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.common_activity_layout.*
import kotlinx.android.synthetic.main.note_list_layout.*
import training.android.fragmentDialog.R
import training.android.fragmentDialog.adapter.NoteAdapter
import training.android.fragmentDialog.interfaces.impl.NoteClickListenerImpl
import training.android.fragmentDialog.model.Note

class NoteListActivity : CommonActivity() {
	lateinit var notes: MutableCollection<Note>
	lateinit var noteAdapter: NoteAdapter
	lateinit var itemNoteListener: View.OnClickListener
	var recyclerview: RecyclerView? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.note_list_layout)
		setSupportActionBar(default_toolbar)
		notes = mutableListOf<Note>()
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
		itemNoteListener = NoteClickListenerImpl(this, notes as List<Note>)
		noteAdapter = NoteAdapter(notes as List<Note>, itemNoteListener)
		recyclerview = note_list
		recyclerview!!.layoutManager = LinearLayoutManager(this)
		recyclerview!!.adapter = noteAdapter
	}
}