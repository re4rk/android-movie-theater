package woowacourse.movie.ui.main.movieList

import woowacourse.movie.model.AdvState
import woowacourse.movie.model.MovieState
import woowacourse.movie.ui.base.BaseContract

interface MovieListContract {
    interface View {
        fun showMovieList(movieList: List<MovieState>, advList: List<AdvState>)
    }

    interface Presenter : BaseContract.Presenter {
        fun setUpMovieList()
    }
}
