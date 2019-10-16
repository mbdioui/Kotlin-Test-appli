package training.android.fragmentDialog.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.common_activity_layout.*
import kotlinx.android.synthetic.main.note_detail_layout.*
import training.android.fragmentDialog.R
import training.android.fragmentDialog.model.Note

class NoteDetailActivity : CommonActivity() {
	companion object {
		val EDIT_NOTE_REQUEST = 1
		val EXTRA_NOTE = "note"
		val EXTRA_NOTE_INDEX = "noteIndex"
		val ACTION_SAVE_NOTE =
			"training.android.fragmentDialog.activities.NoteDetailActivity.saveNote"
		val ACTION_DELETE_NOTE =
			"training.android.fragmentDialog.activities.NoteDetailActivity.deleteNote"
	}

	lateinit var note: Note
	var noteIndex = -1

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.note_detail_layout)
		setSupportActionBar(default_toolbar)
		supportActionBar!!.setDisplayHomeAsUpEnabled(true)
		supportActionBar!!.setTitle("edition d'une note")
		bindNoteInView()
	}

	private fun bindNoteInView() {
		note = intent.getParcelableExtra(EXTRA_NOTE)
		noteIndex = intent.getIntExtra(EXTRA_NOTE_INDEX, -1)
		title_detail.setText(note.title)
		textnote_detail.setText(note.note_text)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.toolbar_note_menu, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.action_save -> {
				saveNote()
			}

			R.id.action_delete -> {
				deleteNote()
			}

			else ->
				super.onOptionsItemSelected(item)
		}
		return true
	}

	private fun saveNote() {
		val note = Note()
		note.title = title_detail.text.toString()
		note.note_text = textnote_detail.text.toString()
		val parentIntent = Intent(ACTION_SAVE_NOTE)
		parentIntent.putExtra(EXTRA_NOTE, note as Parcelable)
		parentIntent.putExtra(EXTRA_NOTE_INDEX, noteIndex)
		setResult(Activity.RESULT_OK, parentIntent)
		finish()
	}

	private fun deleteNote() {
		val parentIntent = Intent(ACTION_DELETE_NOTE)
		parentIntent.putExtra(EXTRA_NOTE_INDEX, noteIndex)
		setResult(Activity.RESULT_OK, parentIntent)
		finish()
	}
}