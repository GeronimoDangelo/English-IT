package com.study.englishit.data.local

import com.study.englishit.R
import com.study.englishit.domain.model.PhrasesModel

object LocalSource {

    //Basic Phrases
    fun providesPhrases0(): MutableList<PhrasesModel> {
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
                7, "Do you have any clue?", "¿Tienes alguna idea?", R.raw.doyouhaveanyclue
            ),
            PhrasesModel(8, "I have no idea!", "No tengo idea!", R.raw.ihavenoidea),
            PhrasesModel(8, " I'm not really sure", "No estoy muy seguro/a", R.raw.imnotreallysure),
            PhrasesModel(8, "That's not how I see it", "Yo no lo veo asi", R.raw.thatsnothowiseeit),
            PhrasesModel(
                8, "I really appreciate that!", "Realmente aprecio eso", R.raw.irllypreciatethat
            ),
        )
    }

    //Questions
    fun providesPhrases1(): MutableList<PhrasesModel> {
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
                4, "Thank god it's Friday!", "¡Gracias a Dios es Viernes!", R.raw.thanksgod
            ),
            PhrasesModel(5, "We'll be in touch", "Estaremos en contacto", R.raw.wellbeintouch),
            PhrasesModel(
                6,
                "Shall we go for drinks after work?",
                "¿Vamos a tomar algo después del trabajo?",
                R.raw.shalweegofordrinks
            ),
            PhrasesModel(
                7, "Correct me if I'm wrong", "Corrígeme si estoy equivocado", R.raw.correctme
            ),
            PhrasesModel(
                8,
                "Is there a discount for students?",
                "¿Hay un descuento para los estudiantes?",
                R.raw.isthereadiscountforstudent
            ),
            PhrasesModel(
                9, "What time suits you?", "¿A qué hora te conviene?", R.raw.whattimesuitsyou
            ),
            PhrasesModel(10, "What do you do?", "¿A qué te dedicas?", R.raw.whatdoyoudo),
            PhrasesModel(11, "That’s a good question!", "¡Buena pregunta!", R.raw.thatgoodquestion),
        )
    }

    //Connectors
    fun providesPhrases2(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(
                1,
                "I love that it allows me to..",
                "Example: Do you like science? \n Yes, I love that it allows me to undertand the world around us. ",
                R.raw.ilovethatitallowsmeto
            ),
            PhrasesModel(
                2,
                "I have a knack for it",
                "Is used to mean: 'to be good/ talented at' \n Se usa para decir que eres muy bueno o talentoso en algo. ",
                R.raw.ihaveanackforit
            ),
            PhrasesModel(3, "I don't get it", "No lo entiendo", R.raw.idontgetit),
            PhrasesModel(4, "Do you like coffee?", "¿Te gusta el cafe?", R.raw.doyoulikecoffee),
            PhrasesModel(
                5,
                "Yes, I can't get enough of it",
                "Sí, no me canso de ello. \n \n Se utiliza para decir cosas como: 'Do you like coffee?' \n 'Yes, I can't get enough of it \n \n 'Nunca me canso de tomar cafe' ",
                R.raw.yesicantgetenoughofit
            ),
            PhrasesModel(6, "Yes, I'm good at it.", "Si, soy bueno en ello.", R.raw.yesimgoodatit),
            PhrasesModel(
                7,
                "What I like most about it..",
                "Lo que mas me gusta acerca de eso...  \n \n Do you like coffee? \n Yes, what I like most about it... is its scent",
                R.raw.whatilikemostaboutit
            ),
        )
    }

    //End a conversation
    fun providesPhrases3(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(
                1,
                "Well, It was nice chatting to you",
                "Bueno, fue agradable conversar contigo. \n \n Se utiliza para terminar la conversacion.",
                R.raw.wellitwasnicechattingwithyou
            ),
            PhrasesModel(
                2,
                "Right! ,I'd better be going",
                "Cierto! Bueno es mejor que me este llendo",
                R.raw.rightibetbegoing
            ),
            PhrasesModel(3, "Take Care!", "Cuidate!", R.raw.takecaree),
            PhrasesModel(
                4,
                "Right!, I need to get going",
                "Bueno! Necesito irme",
                R.raw.ineedtogetgoing
            ),
            PhrasesModel(
                5,
                "Speak to you soon!",
                "Te hablare pronto! \n\n Es como decir 'Nos vemos pronto'.",
                R.raw.speaktoyosoon
            ),
            PhrasesModel(6, "Byebye! or Bye!", "Chau chau! / Adios!", R.raw.byebyeorbyee),
            PhrasesModel(7, "Right! I must be off", "Esata bien! Debo irme", R.raw.rightimustbeoff),
            PhrasesModel(
                8,
                "Have a good one!",
                "Es para desear suerte , ejemplo: 'Cuidate','Ten buena jornada','Suerte!'",
                R.raw.haveagoodone
            ),
            PhrasesModel(
                9,
                "Speak soon!",
                "Es como decir 'Nos vemos pronto'. ",
                R.raw.speakyousoon
            ),
            PhrasesModel(
                10,
                "Send my love to Margaret!",
                "Enviale mi saludo a margaret! \n\n Se utiliza en forma de aprecio hacia una persona, es como para enviar saludos.",
                R.raw.sendmylovetomargaret
            ),
            PhrasesModel(
                11,
                "Talk to you later!",
                "Te hablo luego! \n\n Se utiliza para decir: 'Bye!'.",
                R.raw.talktoyoulater
            ),
        )
    }

    //Job Chat
    fun providesPhrases4(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(
                1,
                "How do you feel about this idea?",
                "¿Cómo te sientes acerca de esta idea? \n\n Es como decir: '¿Como ves esta idea?' ",
                R.raw.howdoyoufeelaboutthisidea
            ),
            PhrasesModel(2, "In my opinion, we need..", "En mi opinion, necesitamos...", R.raw.inmyopininonweneed),
            PhrasesModel(2, "I think that's a good idea!", "Pienso que esa es una buena idea!", R.raw.ithinkthatsagoodidea),
            PhrasesModel(
                2,
                "It's great to finally meet you in person",
                "Es genial conocerte finalmente en persona.",
                R.raw.itsgreattofinallymeetyouinperson
            ),
            PhrasesModel(
                2,
                "The first item in our agenda is...",
                "The first item in our agenda is... \n\n El primer punto de nuestra agenda es..",
                R.raw.thefirstiteminouragendais
            ),
            PhrasesModel(
                2,
                "The purpose of this call is",
                "El proposito de esta convocatoria es",
                R.raw.thepurpouseofthiscallis
            ),
            PhrasesModel(2, "Without a doubt", "Sin ninguna duda!", R.raw.withoutadoubt),
            PhrasesModel(
                2,
                "Yes, i wouldn't think twice about it",
                "Sí, no lo pensaría dos veces",
                R.raw.yesiwoudntthinktwiceaboutit
            ),
        )
    }

    //Social Tech
    fun providesPhrases5(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(
                1,
                "I can't take all the credit..",
                "No puedo tomar todo el credito. \n \n Se usa para cuando se hacen cosas en equipo y tienes que dar creditos a otras personas que han estado en el mismo proyecto.",
                R.raw.icantgetallthecredit
            ),
            PhrasesModel(
                2,
                "I've got a great team working with me",
                "Tengo un equipo genial trabajando conmigo",
                R.raw.ihaveagreatteamworkingwithme
            ),
            PhrasesModel(3, "I'm confused'", "Estoy confundido", R.raw.imconfused),
            PhrasesModel(4, "I don't understand", "No lo entiendo", R.raw.idontunderstand),
            PhrasesModel(
                5,
                "I was rather perplexed by his preposition",
                "Me quede bastante confundido por su propuesta",
                R.raw.iwasratherperplex
            ),
            PhrasesModel(
                6,
                "So.. Would you mind giving me further clarification on that point",
                "¿Te importaría darme más aclaraciones en se punto?",
                R.raw.sowouldyougivemefurtherclarificationonthatpoint
            ),
            PhrasesModel(
                7,
                "Can you explain it again?",
                "¿Lo puedes explicar de nuevo?",
                R.raw.canyouexplainitagain
            ),
            PhrasesModel(
                8,
                "Could you clarify what you meant when you said...",
                "¿Podrías aclarar a qué te referías cuando dijiste...?",
                R.raw.couldyouclarifywhenyousaid
            ),
            PhrasesModel(
                9,
                "Could you clarify what you meant in the meeting?",
                "¿Podría aclarar lo que quiso decir en la reunión?",
                R.raw.couldyouclarufywhatyoumean
            )
        )
    }

    //Time
    fun providesPhrases6(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(1, "Every once in a while", "De vez en cuando", R.raw.everyonceinawhile),
            PhrasesModel(
                2,
                "I've heard so much about you",
                "He oído mucho sobre ti",
                R.raw.ivehearsomuchaboutyou
            ),
            PhrasesModel(3, "That's a nice one", "Esa es buena", R.raw.thatsaniceone),
            PhrasesModel(
                4,
                "To get to down to business",
                "Para ir al punto! \n\n Se usa para decir que se quiere ir directo al asunto , sin vueltas y ponerse a trabajar.",
                R.raw.togetdowntobussines
            ),
            PhrasesModel(5, "From time to time", "De vez en cuando", R.raw.fromtimetotime),
            PhrasesModel(
                6,
                "Think outside of the box",
                "Piensa fuera de la caja \n\n Es como decir , piensa fuera del molde. Se inovador!",
                R.raw.tothinkoutsideofthebox
            ),
            PhrasesModel(
                7,
                "What do you think about the proposal?",
                "¿Que opinas de la propuesta?",
                R.raw.whatdoyoutihnkabouttheproposal
            ),
        )
    }

}