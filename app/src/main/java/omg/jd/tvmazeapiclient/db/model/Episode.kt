package omg.jd.tvmazeapiclient.db.model

import android.os.Parcel
import android.os.Parcelable
import paperparcel.PaperParcel

@PaperParcel
data class Episode(val id: Long = 0,
                   val url: String?,
                   val name: String?,
                   val season: Int = 0,
                   val episode: Int = 0,
                   val airdate: String?,
                   val airtime: String?,
                   val airstamp: String?,
                   val runtime: Int = 0,
                   val mediumImage: String?,
                   val originalImage: String?,
                   val summary: String?,
                   val links: Links?) : Parcelable {

    companion object {
        @JvmField val CREATOR = PaperParcelEpisode.CREATOR
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelEpisode.writeToParcel(this, dest, flags)
    }

}