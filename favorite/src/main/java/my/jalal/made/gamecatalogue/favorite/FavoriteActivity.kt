package my.jalal.made.gamecatalogue.favorite

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_favorite.*
import my.jalal.made.core.ui.GameAdapter
import my.jalal.made.gamecatalogue.detail.DetailGameActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadKoinModules(favoriteModule)

        val gameAdapter = GameAdapter()
        gameAdapter.onItemCLick = { selectedData ->
            val intent = Intent(this, DetailGameActivity::class.java)
            intent.putExtra(DetailGameActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteGame.observe(this, Observer { favoriteGame ->
            gameAdapter.setData(favoriteGame)
            view_empty.visibility = if (favoriteGame.isNotEmpty()) View.GONE else View.VISIBLE

        })

        with(rv_favorite_game) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = gameAdapter
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
}



