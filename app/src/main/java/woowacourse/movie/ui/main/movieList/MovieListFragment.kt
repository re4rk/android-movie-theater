package woowacourse.movie.ui.main.movieList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import woowacourse.movie.R
import woowacourse.movie.databinding.FragmentMovieListBinding
import woowacourse.movie.model.AdvState
import woowacourse.movie.model.MovieState
import woowacourse.movie.ui.adapter.MovieListAdapter
import woowacourse.movie.ui.adv.AdvDetailActivity
import woowacourse.movie.ui.itemModel.AdvItemModel
import woowacourse.movie.ui.itemModel.MovieItemModel
import woowacourse.movie.ui.main.cinemaBottomSheet.CinemaListBottomSheet

class MovieListFragment : Fragment(R.layout.fragment_movie_list) {
    private lateinit var presenter: MovieListContract.Presenter

    private lateinit var binding: FragmentMovieListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setUpPresenter()
        setUpBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MovieListPresenter()

        binding.movieList.adapter = MovieListAdapter(
            movie = presenter.getMovieList().map(::MovieItemModel),
            adv = presenter.getAdvList().map(::AdvItemModel),
            onClickMovie = { movieItemModel -> showCinemaBottomSheet(movieItemModel.movieState) },
            onClickAdv = { advItemModel -> navigateAdbDetail(advItemModel.advState) }
        )
    }

    private fun setUpBinding() {
        binding = FragmentMovieListBinding.inflate(layoutInflater)
    }

    private fun setUpPresenter() {
        presenter = MovieListPresenter()
    }

    private fun showCinemaBottomSheet(movie: MovieState) {
        CinemaListBottomSheet(movie)
            .show(parentFragmentManager, CinemaListBottomSheet.TAG_CINEMA_LIST_BOTTOM_SHEET)
    }

    private fun navigateAdbDetail(adbState: AdvState) {
        AdvDetailActivity.startActivity(activity as Context, adbState)
    }
}