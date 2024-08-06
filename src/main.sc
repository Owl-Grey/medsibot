require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: scripts/utils.js  
require: FAQ.sc
require: operator.sc
require: quizzes.sc
require: makingAppointment.sc
require: function.js

patterns:
    $analysis = ($regexp<[ао]нал[ие]з(а|у|ом|е)?>/$regexp<[ао]нал[ие]з(ы|ов|ами?|ах)>)
    $medAnalyses = ($analysis/~снимок/~рентген/ээг/экг/узи)
    $city_said = ($regexp<москв(a|у|ы)?>/$regexp<питер>)



theme: /

    state: Start
        q!: $regex</start>
        script:
            $client.pid = "1000009591121";
            $client.you = "вы";
            $client.botGender = 'f';
        go!: /Ans4_Start


    state: Ans4_Start
        random:
            a: {{funcYou("Здравствуйте", "Здравствуйте", "Привет")}}, {{($client.patientNameAndPatronym ? $client.patientNameAndPatronym + ", " : "") + "рады " + funcYou("Вас", "вас", "тебя")}} приветствовать в Smartmed! Я чат-бот, отвечу на {{funcYou("Ваши", "ваши", "твои")}} вопросы.
            a: Приветствую {{funcYou("Вас", "вас", "тебя") + ($client.patientNameAndPatronym ? ", " + $client.patientNameAndPatronym : "")}}! Я виртуальный ассистент Smartmed.
            a: {{$client.patientNameAndPatronym ? $client.patientNameAndPatronym + ", добро" : "Добро"}} пожаловать в Smartmed! Я виртуальный помощник и готов {{funcYou("Вам", "вам", "тебе")}} помочь.
        go!: /Ans_SpecifyWhatUInterestedInGeneral


    state: Ans4_Goodbye
        random:
            a: {{funcYou("До свидания", "До свидания", "Пока")}}, {{$client.botGender === "f" ? "рада была" : "рад был"}} помочь. Ждём {{funcYou("Вас", "вас", "тебя")}} снова!
            a: Спасибо, что {{funcYou("выбираете", "выбираете", "выбираешь")}} Smartmed. Всего доброго!
            a: Всего хорошего! Если появятся вопросы, {{funcYou("обращайтесь", "обращайтесь", "обращайся")}}.


    state: Ans_SpecifyWhatUInterestedInGeneral
        random:
            a: {{funcYou("Уточните", "Уточните", "Уточни")}}, пожалуйста, что {{funcYou("Вас", "вас", "тебя")}} интересует:
            a: Что {{funcYou("Вас", "вас", "тебя")}} интересует?
        go!: /Buttons_BotSkills


    state: Buttons_BotSkills
        buttons:
            "Запись на приём к врачу" -> /Интеграция
        buttons:
            "Не отображаются документы"
        buttons:
            "Обратиться к оператору"

        state: react_Refusal
            intent: /sys/aimylogic/ru/negation || toState = "./"
            go!: /startingScenario/Ans4_Goodbye
            

    state: Bye
        intent!: /пока
        go!: /Ans4_Goodbye

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}
        go!: /operator/Ans_PassingToOperatorPleaseWait
        
    state: MakingAppointment
        intent!: /Запись на прием к врачу
        go!: 

    state: OperatorMain
        intent: /Оператор 
        go!: /operator/Ans_PassingToOperatorPleaseWait
        
    state: TestSendImage
        q!: testSendImage
        script:
            $response.replies = $response.replies || [];
                $response.replies.push({
            "type": "image",
            "imageUrl": "https://kartinki.pics/pics/uploads/posts/2022-09/1662615787_1-kartinkin-net-p-milie-kotiki-v-shapochkakh-instagram-1.jpg",
            "imageName": "Котик в шапочке",
            "markup": "html"
                });
        
    state: TestSendPDF
        q!: testSendPDF
        script:
            $response.replies = $response.replies || [];
            $response.replies.push({
                "type": "file",
                "fileUrl": "https://books.googleusercontent.com/books/content?req=AKW5QadFdWZ-r837UfO4SLBULVF8XsYJhXHFEpXHIsXS8ODktDadKRh3Rmt8nNAcXL_0RFoGMyUCCrITy19nh-LIj-kF2WsoQOwjnwDkRignCsWht0oKEwYLiG-dfCbZpS49F1rwcbNZSujj0wLI_9y9gF6OwEnO-r3SOGV9ovASA4453UtcaR3uTvCRUNrfe1HuPU2Qt2rdRqKtPoR0ZqJLgryNEH0HUm_OdpGC2OhQUDdq1Heyagt86G-Q8rAlFaoiDtwiW2H21tB4pxMDkv-DSWVLwJGSKQ",
                "fileName": "AnnaKarenina.pdf",
                "mimeType": "application/pdf"
            });

    state: Интеграция
        script:
            //Getcity('Москва').then(function (res){
              //   $temp.id = res.id
              //   $temp.name = res.name
              //  })
        a: {{$request.accountId}}
        