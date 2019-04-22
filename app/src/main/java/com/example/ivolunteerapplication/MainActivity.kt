package com.example.ivolunteerapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*

class MainActivity : DebugActivity() {
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoLogin = findViewById<Button>(R.id.button)
        botaoLogin.setOnClickListener {onClickLogin() }

    }

    fun onClickLogin(){
        val campoUsuario = findViewById<EditText>(R.id.editText)
        val campoSenha = findViewById<EditText>(R.id.editText2)
        val valorUsuario = campoUsuario.text.toString()
        val valorSenha = campoSenha.text.toString()
        val username = "aluno"
        val password = "impacta"

        if (valorSenha == password  && valorUsuario == username){
            val intent = Intent(context, TelaInicialActivity::class.java)
            startActivity(intent)
        } else {
        Toast.makeText(this, "Nome de usuario ou senha inválidos", Toast.LENGTH_LONG).show()
    }
    }
}
