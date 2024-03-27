package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("PDM24.1","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        val textMsg:TextView = findViewById(R.id.textMsg)
        val switchButton = findViewById<Switch>(R.id.swPercentual)
        val precoAlcool:Double = findViewById<TextView?>(R.id.text_alcool).toString().toDouble()
        val precoGasolina:Double = findViewById<TextView?>(R.id.text_gasolina).toString().toDouble()

        //btCalc.setBackgroundColor(Color.CYAN)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            val switchState = switchButton.isChecked
            if (switchState) {
                percentual = 0.75
                mostrarMsgvaleApenaAlcool(valeApenaAlcool(percentual, precoAlcool, precoGasolina), textMsg)

            } else {
                percentual = 0.7
                mostrarMsgvaleApenaAlcool(valeApenaAlcool(percentual, precoAlcool, precoGasolina), textMsg)

            }

            Log.d("PDM24","No btCalcular, $percentual")
        })
    }

 private fun valeApenaAlcool(percentual:Double, precoAlcool:Double,precoGasolina:Double ):Boolean{
     if (precoAlcool <= percentual * precoGasolina){
         return true;
     }
     return false;
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