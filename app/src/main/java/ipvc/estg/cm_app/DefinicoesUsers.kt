package ipvc.estg.cm_app

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputLayout

class DefinicoesUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_definicoes_users)

        setSupportActionBar(findViewById(R.id.toolbar))

        // calling the action bar
        val actionBar = supportActionBar

        if (actionBar != null) {

            // Customize the back button
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)

            // showing the back button in action bar
            actionBar.setDisplayHomeAsUpEnabled(true)

            // Set toolbar title/app title
            actionBar.title = "Definições"
        }


        val txtEmail = findViewById<TextInputLayout>(R.id.txtEmail)
        val txtTlm = findViewById<TextInputLayout>(R.id.txtTlm)
        val buttonGuardar = findViewById<Button>(R.id.buttonConfirmarEditar)
        val buttonCancelar = findViewById<Button>(R.id.buttonCancelarEditar)
        val buttonEditar = findViewById<Button>(R.id.buttonEditarPerfil)
        buttonEditar.setOnClickListener {
            txtEmail.isEnabled = true
            txtTlm.isEnabled = true
            buttonEditar.isVisible = false
            buttonGuardar.isVisible = true
            buttonCancelar.isVisible = true
        }

        buttonGuardar.setOnClickListener {
            txtEmail.isEnabled = false
            txtTlm.isEnabled = false
            buttonEditar.isVisible = true
            buttonCancelar.isVisible = false
            buttonGuardar.isVisible = false
        }

        buttonCancelar.setOnClickListener {
            txtEmail.isEnabled = false
            txtTlm.isEnabled = false
            buttonEditar.isVisible = true
            buttonCancelar.isVisible = false
            buttonGuardar.isVisible = false
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