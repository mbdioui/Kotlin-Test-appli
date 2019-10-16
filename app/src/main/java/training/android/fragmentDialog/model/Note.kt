package training.android.fragmentDialog.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Note(
	var title: String = "",
	var note_text: String = "",
	var filename: String = ""
) : Parcelable,Serializable {


	constructor(parcel: Parcel) : this(
		parcel.readString()!!,
		parcel.readString()!!,
		parcel.readString()!!
	)

	override fun writeToParcel(
		parcel: Parcel,
		flags: Int
	) {
		parcel.writeString(title)
		parcel.writeString(note_text)
		parcel.writeString(filename)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Note> {
		private val UIID=234432442128
		override fun createFromParcel(parcel: Parcel): Note {
			return Note(parcel)
		}

		override fun newArray(size: Int): Array<Note?> {
			return arrayOfNulls(size)
		}
	}
}