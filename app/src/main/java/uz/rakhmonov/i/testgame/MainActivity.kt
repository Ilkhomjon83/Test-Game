package uz.rakhmonov.i.testgame

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    var javob = 0
    var random1=0
    var random2=0
    var random3=0
    var rdBtnBosildi = -1
    var ishlanganlar=0
    var tJ=0

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "${ishlanganlar+1}-savol", Toast.LENGTH_SHORT).show()
        random()
        randomSonAniqla()
        radEkranYoz()
        ishlanganlar++


            next.setOnClickListener(View.OnClickListener {
            if (rd_A.isChecked) rdBtnBosildi = 0
            if (rd_B.isChecked) rdBtnBosildi = 1
            if (rd_C.isChecked) rdBtnBosildi = 2
            if (rd_D.isChecked) rdBtnBosildi = 3

                if (rd_A.isChecked||rd_B.isChecked||rd_C.isChecked||rd_D.isChecked){

                    if (rdBtnBosildi == tJ) {
//                val media = MediaPlayer.create(this, R.raw.togri)
//                media.start()
                Toast.makeText(this, "to'g'ri javob", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "noto'g'ri javob", Toast.LENGTH_SHORT).show()
//                val media = MediaPlayer.create(this, R.raw.notogri)
//                media.start()
            }
            rd_group.clearCheck()

            random()
            if (ishlanganlar<5){
            Toast.makeText(this, "${ishlanganlar+1}-savol", Toast.LENGTH_SHORT).show()}
            randomSonAniqla()
            radEkranYoz()

            while (ishlanganlar<=5){
                ishlanganlar++
                if (ishlanganlar==6){
                    Toast.makeText(this, "Siz ${ishlanganlar-1} ta savolga javob berdingiz", Toast.LENGTH_SHORT).show()
                }
               break
            }

        }else{

                    Toast.makeText(this, "Iltimos o'z javobingizni belgilang ", Toast.LENGTH_SHORT).show()

                }})
    }

    private fun random() {
        if (ishlanganlar<5){
        var number1 = Random().nextInt(100)
        var number2= Random().nextInt(100)
        var amal = Random().nextInt(4)

        when (amal){
            0->{
                txt_misol.text="$number1+$number2 = "
                javob=number1+number2
            }
            1->{ try
                {
                    if (number1<number2) throw Exception()
                    txt_misol.text = "$number1-$number2 = "
                    javob = number1 - number2
            }catch (e:Exception){
                random()
            }
            }
            2->{
                txt_misol.text="$number1*$number2 = "
                javob=number1*number2
            }
            3->{
                try
                {
                    if (number1%number2 !=0 || number2 == 0) throw Exception()
                    txt_misol.text = "$number1/$number2 = "
                    javob = number1 / number2
                }catch (e:Exception) {
                    random()
                }

                }
            }
        }else{
            txt_misol.visibility= (View.GONE)
        }
    }
    fun randomSonAniqla () {
        random1 = Random().nextInt(100)
        random2 = Random().nextInt(100)
        random3 = Random().nextInt(100)

        if (random1==random2|| random2==random3 || random1==random3||javob==random1||javob==random2||javob==random3){
            randomSonAniqla()
        }
    }
    fun radEkranYoz(){
        if (ishlanganlar<5){

         tJ=Random().nextInt(4)
        when(tJ){
            0-> {
                rd_A.text = javob.toString()
                rd_B.text=random2.toString()
                rd_C.text=random1.toString()
                rd_D.text=random3.toString()
            }
            1-> {
                rd_B.text = javob.toString()
                rd_A.text=random2.toString()
                rd_C.text=random3.toString()
                rd_D.text=random1.toString()
            }
            2-> {
                rd_C.text = javob.toString()
                rd_B.text=random3.toString()
                rd_A.text=random2.toString()
                rd_D.text=random1.toString()
            }
            3-> {
                rd_D.text = javob.toString()
                rd_C.text = random1.toString()
                rd_B.text = random2.toString()
                rd_A.text = random3.toString()
            }

            }

        }else{
            rd_group.visibility=(View.GONE)
            next.visibility=(View.GONE)
            start.visibility =(View.VISIBLE)

        }

    }

    fun start(view: View) {
        radEkranYoz()
        randomSonAniqla()
        txt_misol.visibility= (View.VISIBLE)
        rd_group.visibility=(View.VISIBLE)

        next.visibility=(View.VISIBLE)
        start.visibility =(View.GONE)
        random()
        ishlanganlar=0
        if (ishlanganlar<5){
        Toast.makeText(this, "${ishlanganlar+1}-savol", Toast.LENGTH_SHORT).show()}


    }

}