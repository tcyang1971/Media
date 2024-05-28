package tw.edu.pu.csim.tcyang.media

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import tw.edu.pu.csim.tcyang.media.ui.theme.MediaTheme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("第二頁")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    //val link = "https://www1.pu.edu.tw/~tcyang/handpan.mp4"
    val link = "https://redirector.googlevideo.com/videoplayback?expire=1716901615&ei=j4JVZtitLK2wsvQP3s-ggAg&ip=148.251.92.112&id=o-AMua0Nb08QtR4MGnJxswV9fdAB2UUscpZb9yMZuLUp9h&itag=22&source=youtube&requiressl=yes&xpc=EgVo2aDSNQ%3D%3D&mh=PD&mm=31%2C26&mn=sn-4g5lznek%2Csn-f5f7lne6&ms=au%2Conr&mv=u&mvi=5&pl=22&siu=1&vprv=1&svpuc=1&mime=video%2Fmp4&rqh=1&cnr=14&ratebypass=yes&dur=171.223&lmt=1630130379866549&mt=1716879089&fvip=4&c=ANDROID_TESTSUITE&txp=5311224&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cxpc%2Csiu%2Cvprv%2Csvpuc%2Cmime%2Crqh%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AJfQdSswRQIgLxr-S4UoMh54yHTQo_bmwPF72X0RXUk3TmO_rd7mPFUCIQDW2Oe-7VCDMEjCIM-ooyBvPVsXicA5ii9rggl4xb7U3w%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl&lsig=AHWaYeowRgIhAKk86NgOnZ8Ok6Jt1t0JdBbYau5QpwQ2MTeG2Ewxf40uAiEAqvInYG8p0fK25uMzM6FTRUxUMG8DaaZPH4PmKUSDVqs%3D&range=0-42773427&title=X2Download.com-%E3%80%90%E7%82%BA%E5%8F%B0%E7%81%A3%E6%8B%8D%E6%89%8B%EF%BD%9C%E5%90%91%E9%98%BF%E8%B2%AB%E8%80%81%E5%B8%AB%E8%88%87%E9%BD%8A%E6%9F%8F%E6%9E%97%E5%B0%8E%E6%BC%94%E8%87%B4%E6%95%AC%E3%80%91%E8%AE%93%E4%B8%96%E7%95%8C%E8%81%BD%E8%A6%8B%E7%8E%89%E5%B1%B1%E5%9C%A8%E5%94%B1%E6%AD%8C"

    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)

    val playerView = PlayerView(context)
    playerView.player = exoPlayer
    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true

        onDispose{
            exoPlayer.release()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MediaTheme {
        Greeting2("Android")
    }
}