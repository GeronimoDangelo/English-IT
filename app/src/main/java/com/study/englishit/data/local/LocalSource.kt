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

    //Casual
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

    //After work
    fun providesPhrases7(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(1,"We should discuss this over lunch","Deberíamos discutir esto durante el almuerzo",R.raw.weshoulddiscussthisoverlunch),
            PhrasesModel(2,"We should do this again!","¡Deberíamos hacer esto de nuevo!",R.raw.weshoulddothisagain),
            PhrasesModel(3,"We should talk over dinner","Deberíamos hablar durante la cena",R.raw.weshouldtalkoverdinner),
            PhrasesModel(4,"What do you do for fun?","¿Qué haces para divertirte?",R.raw.whatdoyoudoforfun),
            PhrasesModel(5,"I've already taken so much of your time","Ya he tomado mucho de tu tiempo",R.raw.ialreadytakesomuchofyourtime),
            PhrasesModel(6,"I feel like we've got so much more to talk about","Siento que tenemos mucho más de qué hablar!",R.raw.ifeelthatwehavesomuchtotalkabout),
            PhrasesModel(7,"I'd love to carry this on at another time","Me encantaría continuar con esto en otro momento.",R.raw.ilovetocarrythisonanothertime),
            PhrasesModel(8,"What have I missed ? Fill me in!","¿Qué me he perdido? Cuentame todo!",R.raw.whatimissedfiillmeinn),
        )
    }

    //Short of Time
    fun providesPhrases8(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(1,"How do you get into...'x' ?","Se usa para preguntat como empesate hace X actividad , ejemplo:\n\n How do you get into development?\n ¿Como es que te entraste a la programacion?",R.raw.howdoyougetintooox),
            PhrasesModel(2,"I'm a bit pressed for time!","Estoy un poco presionado por el tiempo! \n\n Se usa para terminar una conversacion y despedirse.",R.raw.imabitpressedfortime),
            PhrasesModel(3,"Right! I need to make a move!","Bueno! Necesito estarme llendo!",R.raw.rightineedtomakeamove),
            PhrasesModel(4,"There's so much to say but  I can't go into it now","Hay tanto que decir, pero no puedo en este momento",R.raw.theressomuchtosaybuticantgetintothatnow),
            PhrasesModel(5,"We should chat over coffee","Deberíamos charlar tomando un café.",R.raw.weshouldchatovercoffee),
            PhrasesModel(6,"What do you do outside of work?","¿Qué haces fuera del trabajo?",R.raw.whatdoyoudooutisdeofwork),
            PhrasesModel(7,"What do you do when you are not working?","¿Qué haces cuando no estás trabajando?",R.raw.whatdoyoudowhenyouarenotworkingg),
            PhrasesModel(8,"What gets you out off bed in the morning?","¿Qué te saca de la cama por la mañana?",R.raw.whatgetsyououtofberinthemorning),
        )
    }

    // Job Interview
    fun providesPhrases9(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(1,"I think I'm a good fit for this job","Creo que soy un buen candidato para este trabajo.",R.raw.ithinkimagoodfitforthisjob),
            PhrasesModel(2,"I'm excited to showcase my skills","Estoy emocionado de mostrar mis habilidades",R.raw.imexcitedtoshowcasemyskilss),
            PhrasesModel(3,"I'm sure I could bring a lot to this job","Estoy seguro de que podría aportar mucho a este trabajo",R.raw.imsureicouldbringalottothisjob),
            PhrasesModel(4,"I never shy away from hard work","Nunca me asusto del trabajo duro",R.raw.inevershyawayfromhardwork),
            PhrasesModel(5,"I'm responsible for settings the marketing goals","Soy responsable de establecer los objetivos de marketing.",R.raw.imresponsibleforsettingthemarketinggoals),
            PhrasesModel(6,"I think I'm a good match for this job","Creo que soy un buen candidato para este trabajo.",R.raw.ithinkimagoodmatchforthisjob),
            PhrasesModel(7,"I'm in charge of making the marketing strategy","Me encargo de hacer la estrategia de marketing.",R.raw.iminchargeofmakingthemarketingstrategy),
            PhrasesModel(8,"My forte is making creative graphics","Mi fuerte es hacer gráficos creativos.",R.raw.myforteismakingcrativegraphics),

        )
    }

    //Career Change
    fun providesPhrases10(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(1,"I'm snowed under with work","Estoy abrumado por tanto trabajo",R.raw.imsnowunder),
            PhrasesModel(2,"I'm up to my neck in deadlines","Estoy hasta el cuello con las fechas limites",R.raw.imuptomyneckindeadlines),
            PhrasesModel(3,"I'm stuck in a rut","Estoy atrapado en un mal lugar/ situacion.",R.raw.imstuckunarut),
            PhrasesModel(4,"I'm not realising my potential","No me estoy dando cuenta de mi potencial.",R.raw.imnotreazlizinmypotencial),
            PhrasesModel(5,"It's time to move on","Es tiempo de moverse",R.raw.itstimetomoveon),
            PhrasesModel(6,"It's time to move on to a new challenge","Es momento de pasar a un nuevo desafío.",R.raw.itstimetomoveontothenextchallenge),
        )
    }

    //Yourself
    fun providesPhrases11(): MutableList<PhrasesModel> {
        return mutableListOf(

            PhrasesModel(1,"The most interesting part for me..","La parte más interesante para mí..",R.raw.themostinterestingpartforme),
            PhrasesModel(2,"I'm a big fan of go karting","Soy un gran fan de karting",R.raw.imabigfanofgokarting),
            PhrasesModel(3,"I'm from a family of four","Soy de una familia de cuatro",R.raw.imfromafamilyoffour),
            PhrasesModel(4,"We are a family of four","Somos una familia de cuatro",R.raw.weareafamiloffour),
            PhrasesModel(5,"I've worked in accounting for three years","He trabajado en contabilidad durante tres años.",R.raw.iveworkedinaccountingforthreeyears),
            PhrasesModel(6,"I have 3 years of experience in the neuroscience field","Tengo 3 años de experiencia en el campo de la neurociencia.",R.raw.ihave3yearsofexperienceintheneurosciencefield),
            PhrasesModel(7,"I'm a biology postgrad","Soy un posgraduado en biologia",R.raw.imabiologypostgrad),
            PhrasesModel(8,"I'm about to graduate","Estoy por graduarme",R.raw.imabouttograduate),




        )

    }


    // Opinion
    fun providesPhrases12(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(9,"IT Manager","IT Manager / Administrador IT",R.raw.itmanager),
            PhrasesModel(10,"I work as an accountant","Trabajo como contador",R.raw.iworkasanaccountant),
            PhrasesModel(11,"As far as I can see , they do.","Por lo que puedo ver, lo hacen.",R.raw.asfarasicanseetheydo),
            PhrasesModel(12,"Off the top of my head","Sin pensarlo mucho",R.raw.offthetopofmyhead),
            PhrasesModel(13,"I would say","Yo diría",R.raw.iwouldsay),
            PhrasesModel(14,"Yes, we will.","Si lo haremos",R.raw.yeswewill),
            PhrasesModel(15,"The reason I think so is because..","La razón por la que lo creo es porque...",R.raw.thereasonithinksoisbecause),
            PhrasesModel(16,"I can't say for sure","No puedo decirlo con seguridad",R.raw.icantsayforsure),
        )
    }

    // Probability
    fun providesPhrases13(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(17,"But it seems to me","Pero me parece..",R.raw.butitseemstome),
            PhrasesModel(18,"I'm not to sure to be honest","No estoy muy seguro para ser honesto",R.raw.imnottosuretobehonest),
            PhrasesModel(19,"Will you go to work tomorrow?","¿Irás al trabajo mañana?",R.raw.willyougotoworktomorrow),
            PhrasesModel(20,"I have lived here for ten years","He vivido aquí durante diez años.",R.raw.ihaveleavedyearfor10years),
            PhrasesModel(21,"It's most probable ","Es lo mas probable",R.raw.itsmostprobable),
            PhrasesModel(21,"I will","Voy a...",R.raw.iwill),
            PhrasesModel(23,"It's highly probable","Es muy probable",R.raw.itshighlyprobable),
            PhrasesModel(24,"There's a good likelihood","Hay una buena probabilidad",R.raw.theresagoodlikelihood),
        )
    }


    // Casual 3
    fun providesPhrases14(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(25,"The reason","La razón",R.raw.thereason),
            PhrasesModel(26,"There's a fair chance","Hay una buena oportunidad",R.raw.theresafairchance),
            PhrasesModel(27,"Online shopping may save time","Las compras en línea pueden ahorrar tiempo",R.raw.onlineshoppingmaysavetime),
            PhrasesModel(28,"The most interesting part for me","La parte mas interesante para mi",R.raw.themostinterestingpartforme),
            PhrasesModel(29,"It's probably..","Es probablemente..",R.raw.itsprobably),
            PhrasesModel(30,"The beaches","Las playas",R.raw.thebeaches),
        )
    }


    // Hometown
    fun providesPhrases15(): MutableList<PhrasesModel> {
        return mutableListOf(
            PhrasesModel(31,"I will call you tomorrow","Te llamaré mañana",R.raw.iwillcallyoutomorrow),
            PhrasesModel(32,"I live in a city where there is not too much traffic","",R.raw.iliveinacitywherethereisnottoomuchtraffic),
            PhrasesModel(33,"Maybe i will go","Talvez vaya",R.raw.maybeiwillgo),
            PhrasesModel(34,"First impressions count","Las primeras impresiones cuentan",R.raw.firstimpressionscount),
            PhrasesModel(35,"You wanna keep it simple and friendly","Quieres mantenerlo simple y amigable",R.raw.youwannakeeptisimple),
            PhrasesModel(37,"I live in Santander","Yo vivo en santander",R.raw.iliveinsantender),
            PhrasesModel(38,"I've been living there for 2 years actually","He estado viviendo allí durante 2 años en realidad",R.raw.ivebeenlivingtherefor2yearsactually),
            PhrasesModel(39,"Yeah , It's a coastal city with some nice beaches","Sí, es una ciudad costera con algunas playas bonitas.",R.raw.yeahitsacoastalcitywithsomenicebeaches),
        )
    }




}