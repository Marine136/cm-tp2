package ipvc.estg.cm_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ScreenPsicologo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_psicologo)

        val cardCalendario = findViewById<CardView>(R.id.cardCalendario)
        cardCalendario.setOnClickListener {
            val intent = Intent(this, CalendarioPsicologo::class.java)
            startActivity(intent)
        }

        val cardDefinicoes = findViewById<CardView>(R.id.cardDefinicoes)
        cardDefinicoes.setOnClickListener {
            val intent = Intent(this, DefinicoesUsers::class.java)
            startActivity(intent)
        }

        val cardInfoPacientes = findViewById<CardView>(R.id.cardPacientes)
        cardInfoPacientes.setOnClickListener {
            val intent = Intent(this, InformacaoPacientes::class.java)
            startActivity(intent)
        }
    }
}