package training.android.fragmentDialog.activities

import android.app.Activity
import android.content.Context
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
	lateinit var mContext: Context
	var recyclerview: RecyclerView? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.note_list_layout)
		mContext = this
		setSupportActionBar(default_toolbar)
		initListStaticValues()
		fabEvent()
		itemNoteListener = View.OnClickListener {
			val index = it.tag as Int
			showNote(index)
		}
		noteAdapter = NoteAdapter(notes as List<Note>, itemNoteListener)
		recyclerview = note_list.apply {
			layoutManager = LinearLayoutManager(applicationContext)
			adapter = noteAdapter
		}

	}

	private fun showNote(index: Int) {
		Intent(this, NoteDetailActivity::class.java).run {
			this.putExtra(
				NoteDetailActivity.EXTRA_NOTE,
				if (index >= 0) notes[index]
				else Note() as Parcelable
			)

			this.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, index)
			startActivityForResult(
				this,
				NoteDetailActivity.EDIT_NOTE_REQUEST
			)
		}

	}

	private fun fabEvent() {
		fab_note?.apply {
			this.setOnClickListener {
				showNote(-1)
			}
			this.setOnLongClickListener {
				Snackbar.make(
					coordinator_list_note,
					"hey don't click too long on fab",
					Snackbar.LENGTH_LONG
				).show()
				true
			}
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
		val note = data.getParcelableExtra<Note>(NoteDetailActivity.EXTRA_NOTE)
		if (index >= 0) {
			note?.let {
				notes.removeAt(index)
				training.android.fragmentDialog.utils.deleteNote(mContext, it)
				noteAdapter.notifyDataSetChanged()

				Snackbar.make(
					coordinator_list_note,
					"note \"${it.title}\" deleted from list",
					Snackbar.LENGTH_SHORT
				)
					.show()
			}
		}
	}

	private fun saveNote(data: Intent) {
		val note = data.getParcelableExtra<Note>(NoteDetailActivity.EXTRA_NOTE)
		note.let {
			val noteIndex: Int = data.getIntExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, -1)
			if (noteIndex >= 0)
				notes[noteIndex] = it
			else
				notes.add(0, it)
			persistNote(this, it)
			noteAdapter.notifyDataSetChanged()
		}
	}
}