package ipvc.estg.cm_app

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
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

        val btnSelectDataHora = findViewById<Button>(R.id.buttonEscolherDataHora)
        val radioEscolherHoraio = findViewById<RadioButton>(R.id.escolherHorario)
        radioEscolherHoraio.setOnClickListener {
            btnSelectDataHora.isVisible = true;
        }

        val horarioDisponivel = findViewById<RadioButton>(R.id.primeiroHorario)
        horarioDisponivel.setOnClickListener {
            btnSelectDataHora.isVisible = false;
        }

        btnSelectDataHora.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            val popupCalendar: View = layoutInflater.inflate(R.layout.calendar_popup, null, false);

            val calendarioMarcarConsulta: CalendarView =
                popupCalendar.findViewById(R.id.calendarioMarcarConsulta);
            val btnSeguinte: Button = popupCalendar.findViewById(R.id.buttonEscolherHora)
            val btnCancelarData: Button = popupCalendar.findViewById(R.id.buttonCancelarData)

            builder.setView(popupCalendar)
            val dialog: AlertDialog = builder.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dialog.show()

            btnCancelarData.setOnClickListener {
                dialog.cancel()
            }

            btnSeguinte.setOnClickListener {
                dialog.cancel()

                val builderClock = AlertDialog.Builder(this)
                val popupClock: View = layoutInflater.inflate(R.layout.clock_popup, null, false)

                val timePicker: TimePicker =
                    popupClock.findViewById(R.id.timePicker);
                val btnFinalizar: Button = popupClock.findViewById(R.id.buttonFinalizar)
                val btnCancelarHora: Button = popupClock.findViewById(R.id.buttonCancelarHora)

                builderClock.setView(popupClock)
                val dialogClock: AlertDialog = builderClock.create()
                dialogClock.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
                dialogClock.show()

                btnCancelarHora.setOnClickListener {
                    dialogClock.cancel()
                }

                btnFinalizar.setOnClickListener {
                    val data = calendarioMarcarConsulta.date
                    val hora = timePicker.hour
                    val minutos = timePicker.minute

                    dialogClock.cancel()

                    Toast.makeText(
                        this@MarcarConsulta,
                        "$data , $hora/$minutos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
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