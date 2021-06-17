package ipvc.estg.cm_app

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

// PARA FAZER LOGOUT ->>> Firebase.auth.signOut()


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        val db = Firebase.firestore
        val userBotaoClicado = intent.getStringExtra("numero")

        var currentUser = auth.currentUser

        val buttonLogin = findViewById<Button>(R.id.butonLogin)

        val username1 = username.text
        val password1 = password.text


        // Botao para fazer login como psicologo ou paciente

        buttonLogin.setOnClickListener {

            // Verifica se há campos vazios
            if (username1.toString().isEmpty()) {
                Toast.makeText(this@LoginActivity, R.string.emailVazio, Toast.LENGTH_SHORT).show()
            }
            if (password1.toString().isEmpty()) {
                Toast.makeText(this@LoginActivity, R.string.passVazia, Toast.LENGTH_SHORT).show()
            }

            else {

                    auth.signInWithEmailAndPassword(username1.toString(), password1.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {

                                val userID = currentUser?.uid

                                // Checar se os dados são de um PACIENTE
                                if (userBotaoClicado == "0") {

                                    val docRef = db.collection("pacientes").document(userID!!)

                                    docRef.get()
                                        .addOnSuccessListener { document ->
                                            if (document.data != null) {

                                                // ID encontrado em "pacientes", ou seja, o ID do user é de um paciente

                                                val user = auth.currentUser
                                                updateUI(user)
                                                val intent = Intent(this, ScreenPaciente::class.java)
                                                startActivity(intent)
                                                finish()

                                            } else {
                                                Log.d(TAG, "Documento não encontrado na Firestore->paciente")
                                                Toast.makeText(this@LoginActivity, R.string.dadosNaoPaciente, Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                        .addOnFailureListener { exception ->
                                            Log.d(TAG, "Erro na procura da coleção da firestore->paciente ", exception)
                                        }



                                }

                                //Checar se os dados sao de um PSICOLOGO
                                if (userBotaoClicado == "1") {

                                    val docRef = db.collection("psicologos").document(userID!!)

                                    docRef.get()
                                        .addOnSuccessListener { document ->
                                            if (document.data != null) {

                                                    // ID encontrado em "psicologos", ou seja, o ID do user é de um psicólogo

                                                    val user = auth.currentUser
                                                    updateUI(user)
                                                    val intent = Intent(this, ScreenPsicologo::class.java)
                                                    startActivity(intent)
                                                    finish()

                                            } else {
                                                Log.d(TAG, "Documento não encontrado na Firestore->psicologo")
                                                Toast.makeText(this@LoginActivity, R.string.dadosNaoPsicologo, Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                        .addOnFailureListener { exception ->
                                            Log.d(TAG, "Erro na procura da coleção da firestore->psicologo ", exception)
                                        }

                                }

                                // Login falhado
                            } else {
                                updateUI(null)
                                Toast.makeText(this@LoginActivity, R.string.loginFalhado, Toast.LENGTH_SHORT).show()

                            }
                     }

            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {

    }


    // Função para checar se o utilizador já está logado

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        var currentUser = auth.currentUser

    }


    // Função para fechar atividade ao clicar no botão "para trás"

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}