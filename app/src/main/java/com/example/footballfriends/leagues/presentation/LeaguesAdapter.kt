import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.footballfriends.R

class LeagueAdapter(
    val onItemClicked: (CompetitionXViewState) -> Unit
) : RecyclerView.Adapter<LeaguesAdapter.ViewHolder>() {




    private val differCallback = object: DiffUtil.ItemCallback<CompetitionXViewState>() {
        override fun areItemsTheSame(oldItem: CompetitionXViewState, newItem: CompetitionXViewState): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CompetitionXViewState, newItem: CompetitionXViewState): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaguesAdapter.ViewHolder {
        return RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_leagues, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LeaguesAdapter.ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}