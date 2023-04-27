package yolo.example.youtubeplayer

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import yolo.example.youtubeplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonPlaysingle.setOnClickListener(this)
        binding.buttonStandalone.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val intent = when (view.id) {
            R.id.buttonPlaysingle -> Intent(this, YoutubeActivity::class.java)
            R.id.buttonStandalone -> Intent(this, StandaloneActivity::class.java)
            else -> throw IllegalArgumentException("Undefined button Clicked")
        }
        startActivity(intent)
    }
}
