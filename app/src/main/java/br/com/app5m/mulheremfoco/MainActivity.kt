package br.com.app5m.mulheremfoco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import egolabsapps.basicodemine.videolayout.VideoLayout
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(){
    lateinit var  frameLayout:FrameLayout
    lateinit var  videoLayout:VideoLayout

    private val viewModel: MainActViewModel by viewModels()

    init {
        lifecycleScope.launchWhenStarted {
            viewModel.startVideoLayout(frameLayout,videoLayout)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoLayout= findViewById(R.id.videoLayout)
        frameLayout= findViewById(R.id.frameLayout)



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