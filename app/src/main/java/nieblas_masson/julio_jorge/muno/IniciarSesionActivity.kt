package nieblas_masson.julio_jorge.muno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IniciarSesionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        val textView: TextView = findViewById(R.id.tv_iniSesion_olvidarContra) as TextView

        textView.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }
}