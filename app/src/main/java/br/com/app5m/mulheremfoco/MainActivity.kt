package br.com.app5m.mulheremfoco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import egolabsapps.basicodemine.videolayout.VideoLayout
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(){
  lateinit var  frameLayout:FrameLayout
  lateinit var  videoLayout:VideoLayout


    init {
        lifecycleScope.launchWhenStarted {
            try {
                // Call some suspend functions.
                var urlVideoBackgroud="https://vod-progressive.akamaized.net/exp=1656568317~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1725%2F17%2F433625737%2F1887755183.mp4~hmac=15e0ad3c3eecc045aededb2dc4478e5a1b2a33272dbb14c4fbc78b36883aabf8/vimeo-prod-skyfire-std-us/01/1725/17/433625737/1887755183.mp4"
                frameLayout = findViewById<FrameLayout>(R.id.frameLayout)
                videoLayout = VideoLayout(this@MainActivity)
                videoLayout.setGravity(VideoLayout.VGravity.centerCrop)
                videoLayout.setIsLoop(true)
                setDataSource(urlVideoBackgroud)
                videoLayout.setSound(false)
                frameLayout.addView(videoLayout)
            } finally {
                // This line might execute after Lifecycle is DESTROYED.
                if (lifecycle.currentState >= Lifecycle.State.STARTED) {

                    // Here, since we've checked, it is safe to run any
                    // Fragment transactions.


                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





    }
    private suspend fun setDataSource(urlVideoBackgroud:String) = coroutineScope {  // this: CoroutineScope
        launch(Dispatchers.IO) {
            try {
                videoLayout.setPathOrUrl(urlVideoBackgroud) // could be any video url

            }catch (exc:Exception){

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        videoLayout.onDestroyVideoLayout()
    }

    override fun onPause() {
        super.onPause()
        videoLayout.onPauseVideoLayout()
    }

    override fun onResume() {
        super.onResume()
        if (::videoLayout.isInitialized)   videoLayout.onResumeVideoLayout()
    }
}