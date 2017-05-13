package omg.jd.tvmazeapiclient.components.search

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchPresenter(val view : MVPSearch.View,
                      val interactor: MVPSearch.Interactor) : MVPSearch.Presenter {

    override fun onSearch(input: String) {
        val text: String = input.trim()

        interactor.searchShows(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view.setShows(it)
                }
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onDestroy() {

    }

}