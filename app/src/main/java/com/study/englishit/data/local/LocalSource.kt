package com.study.englishit.data.local

import com.study.englishit.R
import com.study.englishit.domain.model.PhrasesModel

object LocalSource {

    fun providesPhrases(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(0, "How's it going?", "¿Cómo estás?", R.raw.howitsgoing),
            PhrasesModel(1, "Pretty Good!!", "Bastante bien!!", R.raw.prettygood),
            PhrasesModel(
                2,
                "Can i ask you a question?",
                "¿Te puedo hacer una pregunta?",
                R.raw.caniaskyouaquestion
            ),
            PhrasesModel(3, "Can't Complain!", "No me puedo quejar", R.raw.cantcomplain),
            PhrasesModel(
                4,
                "I'm fine, thanks. How are you?",
                "Estoy bien , gracias. ¿Y tu como estas?",
                R.raw.imfinehowareyou
            ),
            PhrasesModel(5, "Absolutely!", "Absolutamente", R.raw.absolutly),
            PhrasesModel(6, "No worries!", "No hay problema!", R.raw.noworries),
            PhrasesModel(
                7,
                "Do you have any clue?",
                "¿Tienes alguna idea?",
                R.raw.doyouhaveanyclue
            ),
            PhrasesModel(8, "I have no idea!", "No tengo idea!", R.raw.ihavenoidea),
            PhrasesModel(8, " I'm not really sure", "No estoy muy seguro/a", R.raw.imnotreallysure),
            PhrasesModel(8, "That's not how I see it", "Yo no lo veo asi", R.raw.thatsnothowiseeit),
            PhrasesModel(
                8,
                "I really appreciate that!",
                "Realmente aprecio eso",
                R.raw.irllypreciatethat
            ),
        )
    }


    fun providesPhrases2(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(
                0,
                "Can you repeat that please?",
                "¿Puede repetir eso por favor?",
                R.raw.canyourepeat
            ),
            PhrasesModel(
                1,
                "Can you speak slower please?",
                "¿Puedes hablar más lento por favor?",
                R.raw.canyospeakslower
            ),
            PhrasesModel(2, "I'm off tomorrow", "Estoy libre mañana", R.raw.imofftomorrow),
            PhrasesModel(3, "I'm back in on Monday", "Vuelvo el lunes", R.raw.imbackonmonday),
            PhrasesModel(
                4,
                "Thank god it's Friday!",
                "¡Gracias a Dios es Viernes!",
                R.raw.thanksgod
            ),
            PhrasesModel(5, "We'll be in touch", "Estaremos en contacto", R.raw.wellbeintouch),
            PhrasesModel(
                6,
                "Shall we go for drinks after work?",
                "¿Vamos a tomar algo después del trabajo?",
                R.raw.shalweegofordrinks
            ),
            PhrasesModel(
                7,
                "Correct me if I'm wrong",
                "Corrígeme si estoy equivocado",
                R.raw.correctme
            ),
            PhrasesModel(
                8,
                "Is there a discount for students?",
                "¿Hay un descuento para los estudiantes?",
                R.raw.isthereadiscountforstudent
            ),
            PhrasesModel(
                9,
                "What time suits you?",
                "¿A qué hora te conviene?",
                R.raw.whattimesuitsyou
            ),
            PhrasesModel(10, "What do you do?", "¿A qué te dedicas?", R.raw.whatdoyoudo),
            PhrasesModel(11, "That’s a good question!", "¡Buena pregunta!", R.raw.thatgoodquestion),
        )
    }



    fun providesPhrases3(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(1,"I love that it allows me to..", "Example: Do you like science? \n Yes, I love that it allows me to undertand the world around us. ", R.raw.ilovethatitallowsmeto),
            PhrasesModel(2,"I have a knack for it", "Is used to mean: 'to be good/ talented at' \n Se usa para decir que eres muy bueno o talentoso en algo. ",
                R.raw.ihaveanackforit),
            PhrasesModel(3,"I don't get it", "No lo entiendo", R.raw.idontgetit),
            PhrasesModel(4,"Do you like coffee?","¿Te gusta el cafe?", R.raw.doyoulikecoffee),
            PhrasesModel(5,"Yes, I can't get enough of it", "Sí, no me canso de ello. \n \n Se utiliza para decir cosas como: 'Do you like coffee?' \n 'Yes, I can't get enough of it \n \n 'Nunca me canso de tomar cafe' ",
                R.raw.yesicantgetenoughofit),
            PhrasesModel(6,"Yes, I good at it.","Si, soy bueno en ello.", R.raw.yesimgoodatit),
            PhrasesModel(7,"What I like most about it..","Si, soy bueno en ello.",
                R.raw.whatilikemostaboutit),
        )
    }
}