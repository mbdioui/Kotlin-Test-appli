package training.android.fragmentDialog.utils

import android.content.Context
import android.text.TextUtils
import android.util.Log
import training.android.fragmentDialog.model.Note
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.*

private val TAG = "STORAGE"
fun persistNote(
	context: Context,
	note: Note
) {
	if (TextUtils.isEmpty(note.filename)) {
		note.filename = UUID.randomUUID().toString() + ".note"
	}
	val fileOutPut = context.openFileOutput(note.filename, Context.MODE_PRIVATE)
	val outputStream = ObjectOutputStream(fileOutPut)
	outputStream.writeObject(note)
	outputStream.close()
}

 fun deleteNote(
	context: Context,
	note: Note
) {
	context.deleteFile(note.filename)
}

 fun loadNotes(context: Context): MutableList<Note> {
	val notes = mutableListOf<Note>()
	val dir = context.filesDir
	for (filename in dir.list()) {
		val note = loadNote(context, filename)
		Log.i(TAG, "note added $note")
		notes.add(note)
	}
	return notes
}

private fun loadNote(
	context: Context,
	filename: String
): Note {
	val fileOutput = context.openFileInput(filename)
	val inputStream = ObjectInputStream(fileOutput)
	val note = inputStream.readObject() as Note
	inputStream.close()
	return note
}