package br.edu.ifsp.scl.sc303769x.trucoscoreboard

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var scoreA = 0
    private var scoreB = 0

    private lateinit var pontosEquipeATextView: TextView
    private lateinit var pontosEquipeBTextView: TextView
    private lateinit var avisoTextView: TextView

    private lateinit var maisUmEquipeAButton: Button
    private lateinit var maisTresEquipeAButton: Button
    private lateinit var maisUmEquipeBButton: Button
    private lateinit var maisTresEquipeBButton: Button
    private lateinit var reiniciarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        pontosEquipeATextView = findViewById(R.id.pontosEquipeATextView)
        pontosEquipeBTextView = findViewById(R.id.pontosEquipeBTextView)
        avisoTextView = findViewById(R.id.avisoTextView)

        maisUmEquipeAButton = findViewById(R.id.maisUmEquipeAButton)
        maisTresEquipeAButton = findViewById(R.id.maisTresEquipeAButton)
        maisUmEquipeBButton = findViewById(R.id.maisUmEquipeBButton)
        maisTresEquipeBButton = findViewById(R.id.maisTresEquipeBButton)
        reiniciarButton = findViewById(R.id.reiniciarButton)

        maisUmEquipeAButton.setOnClickListener {
            scoreA += 1
            atualizarPlacar()
        }

        maisTresEquipeAButton.setOnClickListener {
            scoreA += 3
            atualizarPlacar()
        }

        maisUmEquipeBButton.setOnClickListener {
            scoreB += 1
            atualizarPlacar()
        }

        maisTresEquipeBButton.setOnClickListener {
            scoreB += 3
            atualizarPlacar()
        }

        reiniciarButton.setOnClickListener {
            scoreA = 0
            scoreB = 0
            atualizarPlacar()
        }

        atualizarPlacar()
    }

    private fun atualizarPlacar() {
        pontosEquipeATextView.text = scoreA.toString()
        pontosEquipeBTextView.text = scoreB.toString()

        val jogoAcabou = scoreA >= 12 || scoreB >= 12

        if (jogoAcabou) {
            val vencedor = if (scoreA >= 12) "Equipe A Venceu!" else "Equipe B Venceu!"
            avisoTextView.text = vencedor
            avisoTextView.setTextColor(android.graphics.Color.parseColor("#4CAF50"))

            habilitarBotoes(false)
            return
        }

        habilitarBotoes(true)

        if (scoreA == 11 && scoreB == 11) {
            avisoTextView.text = "Mão de 11: Jogo no escuro!"
            avisoTextView.setTextColor(android.graphics.Color.parseColor("#D32F2F"))
            maisTresEquipeAButton.isEnabled = false
            maisTresEquipeBButton.isEnabled = false
        } else if (scoreA == 11) {
            avisoTextView.text = "Atenção: Equipe A na Mão de 11!"
            avisoTextView.setTextColor(android.graphics.Color.parseColor("#D32F2F"))
            maisTresEquipeAButton.isEnabled = false
        } else if (scoreB == 11) {
            avisoTextView.text = "Atenção: Equipe B na Mão de 11!"
            avisoTextView.setTextColor(android.graphics.Color.parseColor("#D32F2F"))
            maisTresEquipeBButton.isEnabled = false
        } else {
            avisoTextView.text = ""
        }
    }

    private fun habilitarBotoes(habilitado: Boolean) {
        maisUmEquipeAButton.isEnabled = habilitado
        maisTresEquipeAButton.isEnabled = habilitado
        maisUmEquipeBButton.isEnabled = habilitado
        maisTresEquipeBButton.isEnabled = habilitado
    }
}