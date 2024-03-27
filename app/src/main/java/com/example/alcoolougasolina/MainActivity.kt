package com.example.alcoolougasolina

import android.annotation.SuppressLint
//import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var percentual:Double = 0.7
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalc: Button = findViewById(R.id.btCalcular)
        val textMsg:TextView = findViewById(R.id.textMsg)


        //btCalc.setBackgroundColor(Color.CYAN)
        btCalc.setOnClickListener(View.OnClickListener {

            val switchButton = findViewById<Switch>(R.id.swPercentual)

            val precoAlcoolTextView: TextView = findViewById(R.id.text_alcool)
            val precoGasolinaTextView: TextView = findViewById(R.id.text_gasolina)

            var precoAlcool: Double = 0.0
            var precoGasolina: Double = 0.0

            try {
                precoAlcool = precoAlcoolTextView.text.toString().toDouble()
                precoGasolina  = precoGasolinaTextView.text.toString().toDouble()
            } catch (e: NumberFormatException) {
                println("Erro ao converter o preço do álcool para Double: ${e.message}")
            }

            if(precoAlcool == 0.0 || precoGasolina == 0.0){
                textMsg.text = "Ainda não sei qual é a melhor."

            }else{
                val switchState = switchButton.isChecked
                if (switchState) {
                    percentual = 0.75
                    mostrarMsgvaleApenaAlcool(valeApenaAlcool(percentual, precoAlcool, precoGasolina), textMsg)

                } else {
                    percentual = 0.7
                    mostrarMsgvaleApenaAlcool(valeApenaAlcool(percentual, precoAlcool, precoGasolina), textMsg)

                }

            }


        })
    }

 private fun valeApenaAlcool(percentual:Double, precoAlcool:Double,precoGasolina:Double ):Boolean{
     if (precoAlcool <= percentual * precoGasolina){
         return true
     }
     return false
 }

private fun mostrarMsgvaleApenaAlcool(estado:Boolean, textMsg:TextView){
    if (estado){
        textMsg.text = "Vale apena usar alcool"
    }else{
        textMsg.text = "Não vale apena usar alcool"
    }
}

override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
}