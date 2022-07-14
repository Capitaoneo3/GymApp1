package br.com.app5m.mulheremfoco.ui.fragment.main.home

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import br.com.app5m.mulheremfoco.R
import cn.jzvd.*
import kotlinx.android.synthetic.main.fragment_training_detail.*
import kotlinx.android.synthetic.main.fragment_training_detail.view.*
import org.jzvd.jzvideo.JZVideoA
import java.io.File
import java.lang.reflect.Executable


class TrainingDetailFragment : Fragment() {
 lateinit  var videoview:VideoView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_training_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




         videoview = videoViewXml as VideoView
     /*   val uri: Uri =
            Uri.parse("android.resource://" + requireContext().packageName.toString() + "/" + R.raw.woman_on_gym)
        videoview.setVideoURI(uri)*/
//        videoview.start()


        val jzvdStd: JzvdStd = jz_video2


        jzvdStd.setUp(
            "https://github.com/Capitaoneo3/GymApp1/blob/7aa3095ccd7c8775f52e73960ad42e88b7f002f9/app/src/main/res/raw/woman_on_gym.mp4?raw=true",
            "Título"
        )
        jzvdStd.posterImageView.setImageResource(R.drawable.logo_mulher_ef)
//        jzvdStd.posterImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"))
        /*jzvdStd.backButton.setOnClickListener {
//            Jzvd.releaseAllVideos()

        }*/
        jzvdStd.fullscreenButton.setOnClickListener {
       /*     val intent = Intent (requireContext(), VideoFullScreenActivity::class.java)
            requireContext().startActivity(intent)*/
        }
        try {
            jzvdStd.startVideo()

        }catch (e:Exception){
            e
        }




        midiaButton.setOnClickListener {
            try {
                if ( jzvdStd.mediaInterface.isPlaying){
                    pause()
                    midiaButton.setImageResource(R.drawable.ic_baseline_pause_24)

                    jzvdStd.mediaInterface.pause()

                }else{
                    play()
                    midiaButton.setImageResource(R.drawable.ic_baseline_play_arrow_24)

                    jzvdStd.mediaInterface.start()


                }
            }catch (e:Exception){
                e
                jzvdStd.mediaInterface.prepare()
                jzvdStd.startVideo()

            }


            jzvdStd.onStateAutoComplete()

         /*   if (videoview.isPlaying){
                pause()
                midiaButton.setImageResource(R.drawable.ic_baseline_pause_24)
            }else{
                play()
                midiaButton.setImageResource(R.drawable.ic_baseline_play_arrow_24)

            }*/

        }

        videoview.setOnCompletionListener {
            midiaButton.setImageResource(R.drawable.ic_baseline_pause_24)

        }

    }




    override fun onDestroy() {
        super.onDestroy()
        Jzvd.releaseAllVideos()

        videoview.destroyDrawingCache()
        videoview.removeCallbacks {  }
    }

    override fun onPause() {
        super.onPause()
        pause()
    }

    override fun onResume() {
        super.onResume()
      play()
    }

  private  fun play(){
    if  (::videoview.isInitialized)   videoview.start()
    }

  private  fun pause(){
      if  (::videoview.isInitialized)     videoview.pause()


    }
}