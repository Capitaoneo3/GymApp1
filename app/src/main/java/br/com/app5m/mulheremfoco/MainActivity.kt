package br.com.app5m.mulheremfoco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import egolabsapps.basicodemine.videolayout.VideoLayout
import kotlinx.coroutines.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(){
    lateinit var  frameLayout:FrameLayout
    lateinit var  videoLayout:VideoLayout

    private val viewModel: MainActViewModel by viewModels()

    private lateinit var videoObserver: Observer<Boolean>

    init {
        lifecycleScope.launchWhenStarted {
            viewModel.startVideoLayout(frameLayout,videoLayout,this@MainActivity)
                .invokeOnCompletion {
                    try {
                        viewModel.isPlaying.value =  videoLayout.mediaPlayer.isPlaying

                    }catch (e:Exception){
                        e
                    }

                }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoLayout= findViewById(R.id.videoLayout)
        frameLayout= findViewById(R.id.frameLayout)

        // Create the observer which updates the UI.
        videoObserver = Observer<Boolean> { isPlaing ->
            // Update the UI, in this case, a TextView.
            if (isPlaing) Toast.makeText(this, "asdasdasd", Toast.LENGTH_SHORT).show()
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.isPlaying.observe(this,videoObserver)


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