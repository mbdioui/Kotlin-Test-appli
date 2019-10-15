package training.android.fragmentDialog.activities

import android.os.Bundle
import kotlinx.android.synthetic.main.common_activity_layout.*
import kotlinx.android.synthetic.main.note_detail_layout.*
import training.android.fragmentDialog.R
import training.android.fragmentDialog.model.Note

class NoteDetailActivity : CommonActivity() {
	companion object {
		val EXTRA_NOTE = "note"
		val EXTRA_NOTE_INDEX = "noteIndex"
	}

	lateinit var note: Note
	var noteIndex = -1

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.note_detail_layout)
		setSupportActionBar(default_toolbar)
		note = intent.getParcelableExtra<Note>("note")
		noteIndex = intent.getIntExtra("index", -1)
		title_detail.setText(note.title)
		textnote_detail.setText(note.note_text)
	}

}