package com.example.quizz

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_quizz.*

class QuizzActivity : AppCompatActivity() {

    var Quizs = ArrayList<Quizz>()
    var numbonnerep : Int = 0
    var curentquizindex : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        Quizs.add(Quizz("Quelle est la capitale de l'Algérie ?", "Paris", "Alger", "Cotonou", 2))
        Quizs.add(Quizz("En combien de temps la Terre tourne-t-elle autour du soleil ?", "365 jours", "265 jours", "365 jours et un quart", 3))
        Quizs.add(Quizz("Dans quelle pays parle-t-on l'afrikaans et l'anglais ?", "Rwanda", "Afrique du Sud", "Cameroun", 2))
        Quizs.add(Quizz("Quel peuple a inventé la poudre à canon ?", "Les Chinois", "Les Béninois", "Les Francais", 1))
        Quizs.add(Quizz("Quelle est la capitale du Bénin ?", "Instanbul", "Londre", "Cotonou", 3))
        Quizs.add(Quizz("Combien y a-t-il de joueurs sur le terrain dans une équipe de abse-ball?", "9", "6", "11", 1))
        Quizs.add(Quizz("Qui est l'heroine de 'Notre-Dame de Paris' ?", "Moise", "Esmeralda", "Damien", 2))
        Quizs.add(Quizz("Quelle pièce est absolument à protéger dans un jeu d'échec ?", "La Dame", "Le Valley", "Le roi", 3))
        Quizs.add(Quizz("Combien y a-t-il de signe astrologiques chinois ?", "15", "10", "12", 3))
        Quizs.add(Quizz("Quel est le 2ème nom de l'hippocampe ?", "La cheval de mer", "Le cyborg", "L'alienne", 1))
        Quizs.add(Quizz("Quelle est la différence entre le chameau et le dromadaire ?", "La taille de la queue", "La forme de tete", "Le nombre de bosses", 3))
        Quizs.add(Quizz("Quel précipités observe-t-on quand on mélange du nitrate d'argent avec du chlore ?", "Un précipité jaune", "Un précipité vert", "Un précipité blanc qui ce noircit", 3))
        Quizs.add(Quizz("Quelle ville est surnommé <<Big apple>> aux USA ?", "Californie", "New York", "Las Végas", 2))
        Quizs.add(Quizz("De qui est amoureux Juliette ?", "Roméo", "Gracias", "Antonio", 1))
        Quizs.add(Quizz("Qui est le célèbre joueur anglais marié à une spice girl ?", "David Bechkam", "Rooney", "Neymar", 1))
        Quizs.add(Quizz("Les poulets fermiers sont des poulets qui :", "Vivent dans un élevage", "Peuvent se promener en liberté", "Vivent dans une ville", 2))
        Quizs.add(Quizz("Quel champignon n'existe pas, parmis ces 3 réponses ?", "La trompette de la mort", "Le bolet de céleri", "La barbe de bouc", 2))
        Quizs.add(Quizz("Quel oiseau est un symbole international de paix ?", "L'hirondelle", "La cigogne", "La colombe", 3))
        Quizs.add(Quizz("De combien de musiscien se compose un quartet ?", "14", "5", "4", 3))
        Quizs.add(Quizz("Parmis ces trois langues, laquelle est la plus parlée dans le monde ?", "L'espagnol", "L'allemand", "Le fancais", 1))
        Quizs.add(Quizz("Que fait le niveau de la mer lorsque la Terre se réchauffe ?", "Il reste identique", "Il monte", "Il descend", 2))
        Quizs.add(Quizz("Quelle est la capitale de l'Espagne?", "Lisbonne", "Madride", "Rome", 2))


        showquestion(Quizs.get(curentquizindex))
    }

    fun showquestion (quizz: Quizz){

        quest.setText(quizz.question)
        rep1.setText(quizz.reponse1)
        rep2.setText(quizz.reponse2)
        rep3.setText(quizz.reponse3)

    }

    fun handelanswer(ansId: Int){

        val quiz = Quizs.get(curentquizindex)
        if (quiz.isCorrect(ansId)){
            numbonnerep++
            Toast.makeText(this, "+1" , Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "+0" , Toast.LENGTH_SHORT).show()
        }
        //Pour pouvoir aller sur la question suivante
        curentquizindex++
        if (curentquizindex >= Quizs.size){//Partie Terminer

            var alert = AlertDialog.Builder(this)
            alert.setTitle("Partie terminée")
            alert.setMessage("Tu as obtenu " +numbonnerep+ " bonne(s) réponse(s)")
            alert.setPositiveButton("OK"){dialog: DialogInterface?, which: Int ->
                finish()
            }
            alert.show()
        }else {// La partie continue

            showquestion(Quizs.get(curentquizindex))
        }
    }

    fun onClickrep1(view: View) {
        handelanswer(1)
    }
    fun onClickrep2(view: View) {
        handelanswer(2)
    }
    fun onClickrep3(view: View) {
        handelanswer(3)
    }

}
