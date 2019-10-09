package training.android.fragmentDialog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import training.android.fragmentDialog.R
import training.android.fragmentDialog.interfaces.RecycleViewListener

class CountryAdapter(val countries: Array<String>) :
	RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

	var countryItemListener: RecycleViewListener? = null

	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val icon = itemView.findViewById(R.id.icon) as ImageView
		val name = itemView.findViewById(R.id.country_name) as TextView
		val cardview = itemView.findViewById(R.id.cardview) as CardView
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val inflater = LayoutInflater.from(parent.context)
		val view = inflater.inflate(R.layout.country_item, parent, false)
		return ViewHolder(view)
	}

	override fun getItemCount(): Int {
		return countries.size
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.icon.setImageResource(R.drawable.ic_launcher_foreground)
		holder.name.setText(countries[position])
		holder.cardview.tag = position
		holder.cardview.setOnClickListener { view -> countryItemListener?.onCardViewClick(view) }
		holder.icon.setOnClickListener { view -> countryItemListener?.onIconClick(view) }
		holder.name.setOnClickListener { view -> countryItemListener?.onTextClick(view) }
		holder.cardview.setOnLongClickListener { view ->
			countryItemListener?.onLongClick(view)
			true
		}
	}


}