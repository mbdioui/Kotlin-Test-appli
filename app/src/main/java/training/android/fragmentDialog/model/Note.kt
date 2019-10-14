package training.android.fragmentDialog.model

import android.os.Parcel
import android.os.Parcelable

data class Note(
	var title: String = "",
	var note_text: String = "",
	var filename: String = ""
) : Parcelable {


	constructor(parcel: Parcel) : this(
		parcel.readString()!!,
		parcel.readString()!!,
		parcel.readString()!!
	) {
	}

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
		override fun createFromParcel(parcel: Parcel): Note {
			return Note(parcel)
		}

		override fun newArray(size: Int): Array<Note?> {
			return arrayOfNulls(size)
		}
	}
}