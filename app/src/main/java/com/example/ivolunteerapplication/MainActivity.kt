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

        val ong = OngLogin()
        val campoUsuario = findViewById<EditText>(R.id.editText)
        val campoSenha = findViewById<EditText>(R.id.editText2)

        ong.username = campoUsuario.text.toString()
        ong.password = campoSenha.text.toString()
        taskLogin(ong)

    }

    private fun taskLogin(ong: OngLogin) {

        Thread {
            val token = LoginService.login(ong)
            runOnUiThread {

                if (token.contains("error")){

                    Toast.makeText(this, "Usuario ou senhas invalidos.", Toast.LENGTH_SHORT).show()

                } else {

                    val intent = Intent(context, TelaInicialActivity::class.java)
                    val params = Bundle()
                    params.putString("nome", token)
                    intent.putExtras(params)

                    startActivityForResult(intent, 1)
                }
            }
        }.start()

    }

}
