package ipvc.estg.cm_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val buttonLogin = findViewById<Button>(R.id.butonLogin)

        buttonLogin.setOnClickListener {
            //val intent = Intent(this, ScreenPsicologo::class.java)
            val intent = Intent(this, ScreenPaciente::class.java)
            startActivity(intent)
            finish()

            // aa
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}