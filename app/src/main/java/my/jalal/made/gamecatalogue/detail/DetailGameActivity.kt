package my.jalal.made.gamecatalogue.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_game.*
import my.jalal.made.core.domain.model.Game
import my.jalal.made.gamecatalogue.R
import org.koin.android.viewmodel.ext.android.viewModel

class DetailGameActivity : AppCompatActivity() {

    private val detailGameViewModel: DetailGameViewModel by viewModel()

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_game)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailTourism = intent.getParcelableExtra<Game>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailGame: Game?) {
        detailGame?.let {
            supportActionBar?.title = detailGame.name
            tv_name.text = detailGame.name
            Glide.with(this@DetailGameActivity)
                .load(detailGame.backgroundImage)
                .into(img_photo)
            tv_score.text = detailGame.rating.toString()
            tv_release_date.text = detailGame.releasedDate
            var statusFavorite = detailGame.isFavorite
            setStatusFavorite(statusFavorite)
            iv_favorite.setOnClickListener {
                statusFavorite = !statusFavorite
                detailGameViewModel.setFavoriteTourism(detailGame, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            iv_favorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_pink24dp))
        } else {
            iv_favorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_pink_24dp))
        }
    }
}
