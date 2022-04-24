package tw.edu.pu.csim.tcyang.media

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

class MainActivity : AppCompatActivity() {

    lateinit var mper: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mper = MediaPlayer()

        //不要自動休眠
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        //設定螢幕水平顯示
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
    }

    fun StartPlay(v: View){
        when (v.id) {
            R.id.btn1 -> {
                mper = MediaPlayer.create(this, R.raw.tcyang)
                mper.start()
            }

            R.id.btn2 -> {
                mper = MediaPlayer.create(this, R.raw.fly)
                mper.start()
            }
        }
    }
}