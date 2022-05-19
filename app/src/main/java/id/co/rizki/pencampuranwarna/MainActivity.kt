package id.co.rizki.pencampuranwarna

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var warnaMerah1 : ImageView
    lateinit var warnaMerah2 : ImageView
    lateinit var warnaBiru1 : ImageView
    lateinit var warnaBiru2 : ImageView
    lateinit var warnaHijau1 : ImageView
    lateinit var warnaHijau2  : ImageView
    lateinit var warnaHasil  : ImageView

    // -1 kosong, 0 merah, 1 biru, 2 hijau
    var warnaTerpilih1 = -1
    var warnaTerpilih2 = -1

    val merah = 0
    val biru = 1
    val hijau = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        warnaMerah1 = findViewById<ImageView>(R.id.view_red)
        warnaMerah2 = findViewById<ImageView>(R.id.view_red2)
        warnaBiru1 = findViewById<ImageView>(R.id.view_blue)
        warnaBiru2 = findViewById<ImageView>(R.id.view_blue2)
        warnaHijau1 = findViewById<ImageView>(R.id.view_green)
        warnaHijau2 = findViewById<ImageView>(R.id.view_green2)

        warnaHasil = findViewById<ImageView>(R.id.view_result)

        val reset = findViewById<ImageView>(R.id.iv_reset)


        warnaMerah1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Merah 1 Terpilih")
            selectViewPertama(warnaMerah1,0)
        }

        warnaBiru1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Biru 1 Terpilih")
            selectViewPertama(warnaBiru1,1)
        }

        warnaHijau1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Hijau 1 Terpilih")
            selectViewPertama(warnaHijau1,2)
        }

        warnaMerah2.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Merah 2 Terpilih")
            selectViewKedua(warnaMerah2,0)
        }

        warnaBiru2.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Biru 2 Terpilih")
            selectViewKedua(warnaBiru2,1)
        }

        warnaHijau2.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Hijau 2 Terpilih")
            selectViewKedua(warnaHijau2, 2)
        }

        reset.setOnClickListener {
            clearViewPertama()
            clearViewKedua()
            warnaHasil.setBackgroundColor(Color.parseColor("#000000"))

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
        warnaMerah1.setImageResource(0)
        warnaBiru1.setImageResource(0)
        warnaHijau1.setImageResource(0)
    }

    private fun clearViewKedua() {
        warnaMerah2.setImageResource(0)
        warnaBiru2.setImageResource(0)
        warnaHijau2.setImageResource(0)
    }

    private fun hitungWarna() {
        if(warnaTerpilih1 >=0 && warnaTerpilih2 >= 0) {
            if(warnaTerpilih1 == merah && warnaTerpilih2 == biru || warnaTerpilih1 == biru && warnaTerpilih2 == merah) {
                warnaHasil.setBackgroundColor(Color.parseColor("#ff00ff"))
            } else if(warnaTerpilih1 == merah && warnaTerpilih2 == hijau || warnaTerpilih1 == hijau && warnaTerpilih2 == merah) {
                warnaHasil.setBackgroundColor(Color.parseColor("#ffff00"))
            } else if(warnaTerpilih1 == biru && warnaTerpilih2 == hijau || warnaTerpilih1 == hijau && warnaTerpilih2 == biru) {
                warnaHasil.setBackgroundColor(Color.parseColor("#00ffff"))
            }
        }
    }
}