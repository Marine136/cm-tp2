package ipvc.estg.cm_app

import android.os.Bundle
import android.view.MenuItem
import android.widget.CalendarView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MarcarConsulta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marcar_consulta)

        setSupportActionBar(findViewById(R.id.toolbar))

        // calling the action bar
        val actionBar = supportActionBar

        if (actionBar != null) {

            // Customize the back button
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)

            // showing the back button in action bar
            actionBar.setDisplayHomeAsUpEnabled(true)

            // Set toolbar title/app title
            actionBar.title = "Marcar Consulta"
        }

        val calendarioEscolher = findViewById<CalendarView>(R.id.calendarioMarcarConsulta)
        val radioEscolherHoraio = findViewById<RadioButton>(R.id.escolherHorario)
        radioEscolherHoraio.setOnClickListener {
            calendarioEscolher.isVisible = true;
        }

        val horarioDisponivel = findViewById<RadioButton>(R.id.primeiroHorario)
        horarioDisponivel.setOnClickListener {
            calendarioEscolher.isVisible = false;
        }


    }

    // this event will enable the back
    // function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}