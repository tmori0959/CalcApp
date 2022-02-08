package jp.techacademy.toshio.mori.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
import android.renderscript.Int2
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.view.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ボタンクリック待ち
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)

        // editText1, editText2がnullだと例外処理
        try {

            // 変数への代入
            var EDITTEXT1 = editText1.getText().toString()
            var EDITTEXT2 = editText2.getText().toString()


            // StringからDouble型(小数点へ変換
            var num1: Double = EDITTEXT1.toDouble()
            var num2: Double = EDITTEXT2.toDouble()

            var ans: Double = 0.0

            //計算式
            if (v?.id == R.id.button1) {
                ans = num1 / num2
            } else if (v?.id == R.id.button2) {
                ans = num1 * num2
            } else if (v?.id == R.id.button3) {
                ans = num1 + num2
            } else if (v?.id == R.id.button4) {
                ans = num1 - num2
            }

            intent.putExtra("ANSWER", ans)
            startActivity(intent)

        } catch (e: Exception) {
            // editText1,editText2がnullのときの処理

                Snackbar.make(v!!, "何か数値を入力してください", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }

    }
}

