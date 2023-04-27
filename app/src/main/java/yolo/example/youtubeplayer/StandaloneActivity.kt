package yolo.example.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import yolo.example.youtubeplayer.databinding.ActivityStandaloneBinding

class StandaloneActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityStandaloneBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)
        binding = ActivityStandaloneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonPlayVideo.setOnClickListener(this)
        binding.buttonPlaylist.setOnClickListener(this)

        //-------------------or--------------------------

//        binding.buttonPlayVideo.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                TODO("Not yet implemented")
//            }
//        })

        //-----------------------or----------------------------

//        binding.buttonPlayVideo.setOnClickListener(View.OnClickListener { v ->
//            TODO("Not yet implemented")
//        })

        //-------------or------------------------------

//        val listener = View.OnClickListener { v->
//
//        }
//        binding.buttonPlaylist.setOnClickListener(listener)
//        binding.buttonPlayVideo.setOnClickListener(listener)

    }

    override fun onClick(view: View) {
        val intent = when(view.id){
            R.id.buttonPlayVideo-> YouTubeStandalonePlayer.createVideoIntent(
                this,getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID,0,true,false)
            R.id.buttonPlaylist-> YouTubeStandalonePlayer.createPlaylistIntent(
                this,getString(R.string.GOOGLE_API_KEY), YOUTUBE_PLAYLIST,0,0,true,true)
            else-> throw java.lang.IllegalArgumentException("undefined button clicked")
        }
        startActivity(intent)

    }
}