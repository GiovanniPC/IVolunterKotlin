package com.example.ivolunteerapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoLogin = findViewById<Button>(R.id.button)
        botaoLogin.setOnClickListener { onClickLogin() }

        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome  = Prefs.getString("lembrarNome")
            var lembrarSenha  = Prefs.getString("lembrarSenha")
            editText.setText(lembrarNome)
            editText2.setText(lembrarSenha)
            checkBoxLogin.isChecked = lembrar

        }

    }

    fun onClickLogin(){

        val ong = OngLogin()
        val campoUsuario = findViewById<EditText>(R.id.editText)
        val campoSenha = findViewById<EditText>(R.id.editText2)

        ong.username = campoUsuario.text.toString()
        ong.password = campoSenha.text.toString()

        Prefs.setBoolean("lembrar", checkBoxLogin.isChecked)
        if (checkBoxLogin.isChecked) {
            Prefs.setString("lembrarNome", ong.username)
            Prefs.setString("lembrarSenha", ong.password)
        } else {
            Prefs.setString("lembrarNome", "")
            Prefs.setString("lembrarSenha", "")
        }

        taskLogin(ong)

    }

    private fun taskLogin(ong: OngLogin) {

        val intent = Intent(context, TelaInicialActivity::class.java)

        startActivityForResult(intent, 1)

//        Thread {
//            val token = LoginService.login(ong)
//            runOnUiThread {
//
//                if (token.contains("error")){
//
//                    Toast.makeText(this, "Usuario ou senhas invalidos.", Toast.LENGTH_SHORT).show()
//
//                } else {
//
//                    val intent = Intent(context, TelaInicialActivity::class.java)
//                    val params = Bundle()
//                    params.putString("nome", token)
//                    intent.putExtras(params)
//
//                    startActivityForResult(intent, 1)
//                }
//            }
//        }.start()

    }

}
