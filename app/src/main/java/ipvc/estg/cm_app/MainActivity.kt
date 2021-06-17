package ipvc.estg.cm_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPaciente = findViewById<Button>(R.id.buttonPaciente)
        val buttonPsicologo = findViewById<Button>(R.id.buttonPsicologo)

        buttonPaciente.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("numero", "0")
            startActivity(intent)
            finish()
        }

        buttonPsicologo.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("numero", "1")
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}