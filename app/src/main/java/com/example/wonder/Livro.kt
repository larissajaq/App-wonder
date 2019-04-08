    package com.example.wonder

    import android.content.Context
    import android.media.MediaPlayer
    import android.support.v7.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.SeekBar
    import android.widget.Toast
    import android.os.Handler
    import com.example.wonder.R
    import kotlinx.android.synthetic.main.activity_livro.*
    import java.lang.Exception

    class Livro : AppCompatActivity() {

        private lateinit var mediaPlayer: MediaPlayer
        private lateinit var runnable:Runnable
        private var handler: Handler = Handler()
        private var pause:Boolean = false
        lateinit var comunicacaoBT:ConexaoBluetooth
        lateinit var tempoAcao:Map<Int,Char>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_livro)


            /* A - SERVO MOTOR
               B - LIGA VIBRAR
               C - DESLIGA VIBRAR
               D - LIGA VENTO
               E - DELIGA VENTO
            */

            val readWriteMap = hashMapOf(118 to 'A', 144 to 'B', 144 to 'D', 146 to 'C', 146 to 'E', 156 to 'A',
                179 to 'D', 182 to 'E', 187 to 'D', 187 to 'B', 190 to 'E', 190 to 'C', 202 to 'D', 205 to 'E' )
            tempoAcao=HashMap(readWriteMap)


            // Start the media player
            playBtn.setOnClickListener{

                if(pause){
                    mediaPlayer.seekTo(mediaPlayer.currentPosition)
                    mediaPlayer.start()
                    pause = false


                } else{

                    mediaPlayer = MediaPlayer.create(applicationContext,R.raw.audio_tres_porquinhos)
                    mediaPlayer.start()

                }

                initializeSeekBar()

                playBtn.isEnabled = false
                pauseBtn.isEnabled = true
                stopBtn.isEnabled = true

                mediaPlayer.setOnCompletionListener {
                    playBtn.isEnabled = true
                    pauseBtn.isEnabled = false
                    stopBtn.isEnabled = false
                    Toast.makeText(this,"end",Toast.LENGTH_SHORT).show()
                }

                //Controla a comunicação com o bluetooth
                try {
                    //verifica se o fragmento já existe
                    comunicacaoBT =    supportFragmentManager
                        .findFragmentByTag("comunicacao_BT") as ConexaoBluetooth
                }catch (e: Exception)
                {
                    //cria o fragment caso ele não exista
                    comunicacaoBT = ConexaoBluetooth();
                    supportFragmentManager.beginTransaction()
                        .add(comunicacaoBT, "comunicacao_BT").commit();
                }
            }

            // Pause the media player
            pauseBtn.setOnClickListener {
                if(mediaPlayer.isPlaying){
                    mediaPlayer.pause()
                    pause = true
                    playBtn.isEnabled = true
                    pauseBtn.isEnabled = false
                    stopBtn.isEnabled = true
                    Toast.makeText(this,"media pause",Toast.LENGTH_SHORT).show()
                }
            }
            // Stop the media player
            stopBtn.setOnClickListener{
                if(mediaPlayer.isPlaying || pause.equals(true)){
                    pause = false
                    seek_bar.setProgress(0)
                    mediaPlayer.stop()
                    mediaPlayer.reset()
                    mediaPlayer.release()
                    handler.removeCallbacks(runnable)

                    playBtn.isEnabled = true
                    pauseBtn.isEnabled = false
                    stopBtn.isEnabled = false
                    tv_pass.text = ""
                    tv_due.text = ""
                    Toast.makeText(this,"media stop",Toast.LENGTH_SHORT).show()
                }
            }

            // Seek bar change listener
            seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                    if (b) {
                        mediaPlayer.seekTo(i * 1000)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                }
            })



        }


        // Method to initialize seek bar and audio stats
        private fun initializeSeekBar() {
            seek_bar.max = mediaPlayer.seconds
            var tempoAtual:Int;
            runnable = Runnable {
                tempoAtual= mediaPlayer.currentSeconds
                seek_bar.progress = tempoAtual

                //Aqui verifica se tem uma entrada de tempo para a ação
                if(tempoAcao.containsKey(tempoAtual))
                    comunicacaoBT.write(tempoAcao[tempoAtual]!!.toByte())//se tiver, manda o comando

                tv_pass.text = "${mediaPlayer.currentSeconds} sec"
                val diff = mediaPlayer.seconds - mediaPlayer.currentSeconds
                tv_due.text = "$diff sec"

                handler.postDelayed(runnable, 1000)
            }
            handler.postDelayed(runnable, 1000)
        }
    }



    // Extension property to get media player duration in seconds
    val MediaPlayer.seconds:Int
        get() {
            return this.duration / 1000
        }


    // Extension property to get media player current position in seconds
    val MediaPlayer.currentSeconds:Int
        get() {
            return this.currentPosition/ 1000
        }

