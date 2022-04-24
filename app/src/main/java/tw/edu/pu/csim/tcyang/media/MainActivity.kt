package tw.edu.pu.csim.tcyang.media

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    lateinit var mper: MediaPlayer

    lateinit var vdv: VideoView
    lateinit var vidControl: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mper = MediaPlayer()

        //不要自動休眠
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        //設定螢幕水平顯示
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        vdv = findViewById<VideoView>(R.id.vdv)
        vidControl = MediaController(this)
        vdv.setMediaController(vidControl)
    }

    fun StartPlay(v: View){
        mper.reset()
        when (v.id) {
            R.id.btn1 -> {
                mper = MediaPlayer.create(this, R.raw.tcyang)
                mper.start()
            }

            R.id.btn2 -> {
                mper = MediaPlayer.create(this, R.raw.fly)
                mper.start()
            }

            R.id.btn3 -> {
                //vdv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.love))
                vdv.setVideoPath("http://www.ebookfrenzy.com/android_book/movie.mp4")
                vdv.start()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(mper != null) {
            mper.release()
        }
    }

    override fun onPause() {
        super.onPause()
        if(mper != null && mper.isPlaying()){
            mper.pause()
        }
        else{
            mper.reset()
        }
    }

    override fun onResume() {
        super.onResume()
        if(mper != null){
            mper.start()
        }
    }

}