package com.example.ivolunteerapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastro_ong.*

class OngCadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_ong)
        setTitle("Ong Cadastrada!")
        salvarOng.setOnClickListener {
            val ong = Ong()
            ong.name = nomeOng.text.toString()
            ong.username = usernameOng.text.toString()
            ong.email = emailOng.text.toString()
            ong.responsavel = criadorOng.text.toString()
            ong.data_abertura = dataaberturaOng.text.toString()
            ong.phone = phoneOng.text.toString()
            ong.address = addressOng.text.toString()
            ong.city = cityOng.text.toString()
            ong.state = stateOng.text.toString()
            ong.descricao = descricaOng.text.toString()
            ong.cnpj = cnpjOng.text.toString()
            ong.password = passwordOng.text.toString()
            ong.status = true.toString()
            ong.area_atuacao = "saude"
            taskAtualizar(ong)
        }
    }
    private fun taskAtualizar(ong: Ong) {

        Thread {
            OngService.save(ong)
            runOnUiThread {
                finish()
            }
        }.start()
    }
}