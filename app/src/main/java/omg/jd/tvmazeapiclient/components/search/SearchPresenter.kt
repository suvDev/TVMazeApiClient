package omg.jd.tvmazeapiclient.components.search

import io.reactivex.android.schedulers.AndroidSchedulers
import omg.jd.tvmazeapiclient.components.search.recyclerview.SearchItemViewHolder
import omg.jd.tvmazeapiclient.entity.TvShow
import omg.jd.tvmazeapiclient.ws.convertToTvShowEntity

class SearchPresenter(val interactor: MVPSearch.Interactor) : MVPSearch.Presenter {

    override var view: MVPSearch.View? = null

    override fun onSearch(input: String) {
        val searchQuery: String = input.trim()

        view?.setLoading()
        interactor.searchShows(searchQuery)
                .map { it.map { it.show.convertToTvShowEntity() } }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { // onNext
                            view?.setShows(it)
                        },
                        { // onError
                            it.printStackTrace()
                            view?.errorOnGettingList()
                        },
                        { // onComplete
                        }
                )
    }

    override fun onItemClick(viewHolder: SearchItemViewHolder) {
        view?.showDetails(viewHolder.data as TvShow, viewHolder.transitedView)
    }


}
