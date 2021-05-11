package nieblas_masson.julio_jorge.muno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val textView : TextView = findViewById(R.id.et_registro_cuentaExistente) as TextView

        textView.setOnClickListener {
            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

    }
}