package training.android.fragmentDialog.adapter

import android.view.*
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import training.android.fragmentDialog.R
import training.android.fragmentDialog.model.Note

class NoteAdapter(
	val notes: List<Note>,
	var itemClickListener: View.OnClickListener
) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

	class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val noteCard = itemView.findViewById(R.id.notecard) as CardView
		val title = noteCard.findViewById(R.id.title_note) as TextView
		val excerpt = noteCard.findViewById(R.id.excerpt_note) as TextView
	}

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): NoteHolder {
		return NoteHolder(
			LayoutInflater.from(parent.context).inflate(
				R.layout.item_note,
				parent,
				false
			)
		)
	}

	override fun getItemCount(): Int {
		return notes.size
	}

	override fun onBindViewHolder(
		holder: NoteHolder,
		position: Int
	) {
		holder.apply {
			title.text = notes[position].title
			excerpt.text = notes[position].note_text
			noteCard.tag = position
			noteCard.setOnClickListener(itemClickListener)
		}
	}
}