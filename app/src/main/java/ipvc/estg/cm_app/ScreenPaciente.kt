package ipvc.estg.cm_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ScreenPaciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_paciente)

        val cardCalendario = findViewById<CardView>(R.id.cardCalendarioPaciente)
        cardCalendario.setOnClickListener {
            val intent = Intent(this, CalendarioPaciente::class.java)
            startActivity(intent)
        }

        val cardDefinicoesUsers = findViewById<CardView>(R.id.cardDefinicoesPaciente)
        cardDefinicoesUsers.setOnClickListener {
            val intent = Intent(this, DefinicoesUsers::class.java)
            startActivity(intent)
        }

        val cardQuestionarios = findViewById<CardView>(R.id.cardQuestionarios)
        cardQuestionarios.setOnClickListener {
            val intent = Intent(this, Questionarios::class.java)
            startActivity(intent)
        }

        var cardMarcarConsulta = findViewById<CardView>(R.id.cardMarcarConsulta)
        cardMarcarConsulta.setOnClickListener {
            val intent = Intent(this, MarcarConsulta::class.java)
            startActivity(intent)
        }
    }
}