package nieblas_masson.julio_jorge.muno

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import nieblas_masson.julio_jorge.muno.R
import com.google.firebase.auth.FirebaseAuth
import  com.google.firebase.ktx.Firebase
import  com.google.firebase.auth.ktx.auth


class RegistroActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        auth = Firebase.auth


        val btn_registrar: Button = findViewById(R.id.btn_registrar)
        val spinnerPais: Spinner = findViewById(R.id.spinner_pais)
        //Crea un ArrayAdapter usando el string array y el default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.pais_array,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            //Especifica el layout para usar cuando la lista de opciones aparecen
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            //Aplica el adapter al spinner
            spinnerPais.adapter = adapter
        }

        btn_registrar.setOnClickListener{
            valida_registro()
        }
        val spinnerGenero: Spinner = findViewById(R.id.spinner_genero)
        //Crea un ArrayAdapter usando el string array y el default spinner layout
        ArrayAdapter.createFromResource(
            this,
                    R.array.genero_array,
                    android.R.layout.simple_spinner_item
        ).also {adapter ->
            //Especifica el layout para usar cuando la lista de opciones aparecen
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            //Aplica el adapter al spinner
            spinnerGenero.adapter = adapter
        }

        btn_registrar.setOnClickListener{
            valida_registro()
        }
    }

    private fun valida_registro(){

        val et_correo: EditText = findViewById(R.id.et_correo_reg)
        val et_contra1: EditText = findViewById(R.id.et_contra_reg)
        val et_contra2: EditText = findViewById(R.id.et_contra2_reg)
        val et_nombre: EditText = findViewById(R.id.et_nombre_reg)
        val et_sexo: EditText = findViewById(R.id.et_sexo_reg)


        var correo: String = et_correo.text.toString()
        var contra1: String = et_contra1.text.toString()
        var contra2: String = et_contra2.text.toString()
        var nombre: String = et_nombre.text.toString()
        var sexo: String = et_sexo.text.toString()

        if(!correo.isNullOrBlank() && !contra1.isNullOrBlank() &&
            !contra2.isNullOrBlank()&& !nombre.isNullOrBlank() && !sexo.isNullOrBlank()){

            if(contra1 == contra2){

                registrarFirebase(correo, contra1, nombre, sexo)


            }else{
                Toast.makeText(this, "Las contraseña no coinciden",
                    Toast.LENGTH_SHORT).show()
            }

        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }
    private fun registrarFirebase(email: String,password: String, nombre: String, sexo: String){

        auth.createUserWithEmailAndPassword(email, password)

            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    // Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    //  updateUI(user)
                    Toast.makeText(baseContext, "${user.email }se ha creado correctamente",
                        Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    //  Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //  updateUI(null)
                }
            }
    }
}