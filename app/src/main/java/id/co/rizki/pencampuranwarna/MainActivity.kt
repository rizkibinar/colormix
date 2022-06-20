package id.co.rizki.pencampuranwarna

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import id.co.rizki.pencampuranwarna.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    // -1 kosong, 0 merah, 1 biru, 2 hijau
    var warnaTerpilih1 = -1
    var warnaTerpilih2 = -1

    val merah = 0
    val biru = 1
    val hijau = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewRed.setOnClickListener {
                Log.d(MainActivity::class.java.simpleName, "Merah 1 Terpilih")
                selectViewPertama(binding.viewRed,0)
            }
            viewBlue.setOnClickListener {
                Log.d(MainActivity::class.java.simpleName, "Biru 1 Terpilih")
                selectViewPertama(binding.viewBlue,1)
            }
            viewGreen.setOnClickListener {
                Log.d(MainActivity::class.java.simpleName, "Hijau 1 Terpilih")
                selectViewPertama(binding.viewGreen,2)
            }

            viewRed2.setOnClickListener {
                Log.d(MainActivity::class.java.simpleName, "Merah 2 Terpilih")
                selectViewKedua(binding.viewRed2,0)
            }

            viewBlue2.setOnClickListener {
                Log.d(MainActivity::class.java.simpleName, "Biru 2 Terpilih")
                selectViewKedua(binding.viewBlue2,1)
            }

            viewGreen2.setOnClickListener {
                Log.d(MainActivity::class.java.simpleName, "Hijau 2 Terpilih")
                selectViewKedua(binding.viewGreen2, 2)
            }

            ivReset.setOnClickListener {
                clearViewPertama()
                clearViewKedua()
                binding.viewResult.setBackgroundColor(Color.parseColor("#000000"))

            }
        }
    }

    private fun selectViewPertama(view: ImageView, pilihan : Int) {
        warnaTerpilih1 = pilihan
        clearViewPertama()
        view.setImageResource(R.drawable.ic_baseline_check_24)
        hitungWarna()
    }

    private fun selectViewKedua(view: ImageView, pilihan : Int) {
        warnaTerpilih2 = pilihan
        clearViewKedua()
        view.setImageResource(R.drawable.ic_baseline_check_24)
        hitungWarna()
    }

    private fun clearViewPertama() {
        binding.apply {
            viewRed.setImageResource(0)
            viewBlue.setImageResource(0)
            viewGreen.setImageResource(0)
        }
    }

    private fun clearViewKedua() {
        binding.apply {
            viewRed2.setImageResource(0)
            viewBlue2.setImageResource(0)
            viewGreen2.setImageResource(0)
        }
    }

    private fun hitungWarna() {
        if(warnaTerpilih1 >=0 && warnaTerpilih2 >= 0) {
            if(warnaTerpilih1 == merah && warnaTerpilih2 == biru || warnaTerpilih1 == biru && warnaTerpilih2 == merah) {
                binding.viewResult.setBackgroundColor(Color.parseColor("#ff00ff"))
            } else if(warnaTerpilih1 == merah && warnaTerpilih2 == hijau || warnaTerpilih1 == hijau && warnaTerpilih2 == merah) {
                binding.viewResult.setBackgroundColor(Color.parseColor("#ffff00"))
            } else if(warnaTerpilih1 == biru && warnaTerpilih2 == hijau || warnaTerpilih1 == hijau && warnaTerpilih2 == biru) {
                binding.viewResult.setBackgroundColor(Color.parseColor("#00ffff"))
            }
        }
    }
}