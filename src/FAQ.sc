theme: /FAQ

    state: WorkingHoursAndAddress
        intent!: /Время работы и адрес клиники
        q!: testClinicTimeAddress
        go!: /FAQ/Ans4_WorkingHoursAndAddress


    state: ChatWithDoctor4OnlineConsultation
        intent!: /Где найти чат с врачом для проведения онлайн-консультации
        go!: /FAQ/Ans4_ChatWithDoctor4OnlineConsultation


    state: LoyaltyBonusInfoInApp
        intent!: /Информация по бонусам лояльности в приложении
        go!: /FAQ/Ans4_LoyaltyBonusInfoInApp


    state: HowToAddDMSInApp
        intent!: /Как добавить полис ДМС в приложение (отображается стоимость при записи)
        go!: /FAQ/Ans4_HowToAddDMSInApp


    state: HowToAddProfile4Relative
        intent!: /Как добавить профиль ребенка, родственника
        go!: /FAQ/Ans4_HowToAddProfile4Relative

    state: HowToOrderMedicalCertificate
        intent!: /Как заказать справку
        q!: testOrderCertificate
        go!: /FAQ/Ans4_HowToOrderMedicalCertificate


    state: HowToChangePhoneNumberInApp
        intent!: /Как изменить номер телефона в приложении?
        go!: /FAQ/Ans4_HowToChangePhoneNumberInApp


    state: HowToPayBill
        intent!: /Как оплатить счёт?
        go!: /FAQ/Ans4_HowToPayBill


    state: HowToDeplugAutoinformer
        intent!: /Как отключить автоинформатор с напоминанием о приеме в клиниках?
        go!: /FAQ/тестируем интеграции

    state: CantDeleteProfileInApp
        intent!: /Не могу удалить свой профиль в приложении или добавленных пациентов (членов семьи)
        go!: /FAQ/NewState

    state: CheckAnotherPatientReferrals
        intent!: /Посмотреть направления на анализы, исследования другого пациента
        go!: /FAQ/Ans_ReferralsArentReflectedInApp


    state: CheckAnotherPatientResultsOfCheckups
        intent!: /Посмотреть результаты исследований, протоколы осмотров другого пациента
        go!: /FAQ/Ans4_CheckAnotherPatientResultsOfCheckups


    state: CheckYourReferrals
        intent!: /Посмотреть свои направления на анализы, исследования
        script:
            $temp.pathToAnsFAQ = '/FAQ/Ans_ReferralsArentReflectedInApp';
        go!: /FAQ/CheckPid


    state: CheckYourResultsOfCheckupsInLK
        intent!: /Посмотреть свои результаты исследований, протоколы осмотров в ЛК на сайте
        script:
            $temp.pathToAnsFAQ = '/FAQ/Ans4_CheckYourResultsOfCheckupsInLK';
        go!: /FAQ/CheckPid


    state: CheckYourResultsOfCheckupsInApp
        intent!: /Посмотреть свои результаты исследований, протоколы осмотров в приложении
        q!: testSeeOwnResults
        script:
            $temp.pathToAnsFAQ = '/FAQ/Ans4_CheckYourResultsOfCheckupsInApp'
        go!: /FAQ/CheckPid


    state: WhyBonusesTakenOffOrDidntCome
        intent!: /Почему не были начислены или списались бонусы лояльности
        q!: testSpendingBonuses
        go!: /FAQ/Ans4_WhyBonusesTakenOffOrDidntCome

    state: WhyQRDoesntComeOnEmail
        intent!: /Почему не приходит на электронную почту QR-код с информацией о приеме?
        go!: /FAQ/Ans4_WhyQRDoesntComeOnEmail


    state: WhatsIncludedInMyInsurance
        intent!: /Что входит в мою страховку?
        go!: /FAQ/Ans4_WhatsIncludedInMyInsurance



    state: Ans4_Vaccination
        q!: Ans4_Vaccination
        a: В «Медси» проводится вакцинация от COVID-19 пациентов старше 18 лет вакцинами «Спутник V», «Спутник Лайт» и «КовиВак». \nНеобходимые документы: полис ОМС, СНИЛС, паспорт гражданина РФ.
        a: Подробнее на [сайте](https://medsi.ru/lands/vaktsinatsiya-ot-novoy-koronavirusnoy-infektsii-covid-19-v-medsi.php) «Медси».
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_WorkingHoursAndAddress
        a: Информацию об адресах и режиме работы клиник «Медси» можно посмотреть на сайте по [ссылке](https://medsi.ru/clinics/)
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_ChatWithDoctor4OnlineConsultation
        a: Чтобы заказать онлайн-консультацию, необходимо: <ul> <li> на странице «Запись» выбрать члена семьи, для которого необходима консультация; </li> <li> выбрать раздел «Онлайн-консультация»; </li> <li> выбрать специализацию врача, консультация которого необходима; </li> <li> выбрать дату, время онлайн-консультации и ФИО врача; </li> <li> оплатить услугу с привязанной банковской карты; </li> <li> ожидать связи с врачом в запланированное время. </li> </ul>
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_LoyaltyBonusInfoInApp
        a: Для просмотра информации по бонусам {{funcYou("зайдите", "зайдите", "зайди")}} в раздел меню «Ещё» – «Бонусы лояльности», где хранится история начислений и списаний.
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_HowToAddDMSInApp
        a: Добавлять номер полиса ДМС в SmartMed не нужно. Перечень услуг рекомендуем уточнить в страховой компании или посмотреть в договоре. Если приём входит в программу страхования, то он будет в рамках страховки. Также обратите, пожалуйста, внимание на список филиалов, доступных по {{funcYou("Вашему", "вашему", "твоему")}} полису. При визите в клинику достаточно иметь с собой паспорт: если данные полиса внесены в медицинскую карту, в регистратуре смогут увидеть всю необходимую информацию.
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_HowToAddProfile4Relative
        a: Для добавления профиля необходимо зайти в раздел меню «Ещё» – «Моя семья», нажать на значок «+» и заполнить анкетные данные пациента.
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_HowToOrderMedicalCertificate
        a: Для получения пакета документов для налогового вычета необходимо обратиться с паспортом в регистратуру любой клиники в часы работы (исключения: детская клиника на Пироговской, клиники на «Тульской», на «Пражской», в Астрадамском проезде, на «Варшавской», на Гамалеи) для заполнения заявления. При себе иметь следующие документы: <ol> <li> паспорт; </li> <li> оригиналы всех чеков за оплату услуг (если их нет, лицевые счета оформляют в клинике); </li> <li> оригинал договора на оказание услуг (если договора нет, он распечатывается в клинике); </li> <li> ксерокопия паспорта (всех заполненных страниц); </li> <li> ксерокопия свидетельства ИНН или номер ИНН. </li> </ol>
        go!: /goAnsQuizzes/Ans_CanIHelpMore

    state: Ans4_HowToChangePhoneNumberInApp
        a: Для удаления/изменения номера телефона рекомендуем {{funcYou("Вам", "вам", "тебе")}} написать в техподдержку приложения SmartMed: раздел меню «Ещё» – «Вопросы и ответы» – пункт «Обратная связь» внизу страницы. {{funcYou("Обратите", "Обратите", "Обрати")}} внимание! Для успешной синхронизации данных номер телефона в профиле и номер телефона в медкарте клиники должны совпадать.
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_HowToPayBill
        a: При записи через приложение SmartMed {{funcYou("Вы можете", "вы можете", "ты можешь")}} в нём же произвести оплату: <ul> <li> сразу – при оформлении онлайн-консультации или покупке пакета услуг; </li> <li> перед посещением клиники или после его завершения и получения итогового счёта за услуги. </li> </ul>Также можно совершить оплату через приложение «СберБанк Онлайн» по QR-коду, полученному в клинике.
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_HowToDeplugAutoinformer
        a: Настроить отключение автоинформатора можно в приложении SmartMed: раздел меню «Ещё» – «Настройки» – «Уведомления» – «Подтверждение приёма».
        go!: /goAnsQuizzes/Ans_CanIHelpMore

    state: Ans4_CantDeleteProfileInApp
        a: Для удаления профиля необходимо написать в службу техподдержки через приложение SmartMed: раздел меню «Вопросы и ответы» – «Обратная связь».
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans_ReferralsArentReflectedInApp
        q!: testAns_ReferralsArentReflectedInApp
        script:
            var medsiUrl = "https://medsi.ru/";
            var ans = "В приложении SmartMed направления на анализы/исследования не отображаются. Рекомендуем для их просмотра воспользоваться Личным кабинетом на ";
            $reactions.answer(ans + '[сайте](' + medsiUrl + ') «Медси».');
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_CheckAnotherPatientResultsOfCheckups
        a: Посмотреть информацию в профиле члена семьи/ребёнка можно в разделе меню «Медкарта». Для этого в правом верхнем углу {{funcYou("нажмите", "нажмите", "нажми")}} на круглый значок с буквой ({{funcYou("Вашим", "вашим", "твоим")}} инициалом) и {{funcYou("выберите", "выберите", "выбери")}} нужного пациента. Предварительно необходимо добавить члена семьи/ребёнка в разделе меню «Ещё» – «Моя семья».
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_CheckYourResultsOfCheckupsInLK
        q!: testAns4_CheckYourResultsOfCheckupsInLK
        script:
            var lkDocksUrl = "https://medsi.ru/lk/lk-docs.php";
            var go = funcYou("перейдите", "перейдите", "перейди");
            var press = funcYou("нажмите", "нажмите", "нажми");
            var ans1 = "Для просмотра результатов исследований " + go;
            var ans2 = " в меню Личного кабинета и " + press + " «Обновить».";
            $reactions.answer(ans1 + " по <a href=" + lkDocksUrl + ">ссылке</a> " + ans2);
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_CheckYourResultsOfCheckupsInApp
        a: Для отображения в SmartMed записей, документов с результатами анализов и протоколами исследований необходимо, чтобы в приложении использовались те же три параметра, что указаны в карте пациента: <ul> <li> ФИО; </li> <li> дата рождения; </li> <li> контактный номер телефона. </li> </ul>При регистрации в приложении синхронизация с медицинской картой происходит примерно через сутки. В приложении SmartMed не отображаются: <ul> <li> направления на анализы/исследования; </li> <li> записи на услуги, которых нет в приложении; </li> <li> онкомаркеры, гистология (биопсия), онкоцитология; </li> <li> результаты анализов на ВИЧ, СПИД, сифилис; </li> <li> маркеры гепатита; </li> <li> анализы предгоспитальной подготовки; </li> <li> результат генетического теста «Атлас»; </li> <li> ОКТ сетчатки; </li> <li> результаты приёма психолога/психотерапевта/нейропсихолога; </li> <li> результаты приёма мануального терапевта/процедуры; </li> <li> результаты приёма физиотерапевта/физиопроцедуры; </li> <li> результаты приёмов, исследований, пройденных в рамках профосмотра; </li> <li> информация об операциях, любые записи в рамках госпитализации; </li> <li> информация о манипуляциях медицинской сестры; </li> <li> результаты приёма анестезиолога; </li> <li> результаты приёма фтизиатра. </li> </ul>
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_WhyBonusesTakenOffOrDidntCome
        a: По данному вопросу рекомендуем написать на электронный адрес claim@medsigroup.ru.
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_WhyQRDoesntComeOnEmail
        a: Для уточнения информации по QR-коду рекомендуем {{funcYou("Вам", "вам", "тебе")}} обратиться в регистратуру клиники.
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: Ans4_WhatsIncludedInMyInsurance
        a: Полный перечень услуг и клиник можно уточнить в страховой компании или посмотреть в договоре.
        go!: /goAnsQuizzes/Ans_CanIHelpMore


    state: CheckPid
        if: !$temp.begin && !$client.pid
            script:
                $temp.begin = true;
                $temp.returnPath = $context.currentState;
            #go!: /problemsAnsFunc/GetUserInfo_DYN
        else:
            if: $client.response && $client.response.status === "success" || $client.isPidNullOnStart
                script:
                    delete $temp.begin;
                    if (!$client.pid) {
                        return $reactions.transition('operator/Ans_PassingToOperatorPleaseWait');
                    }
                    if ($temp.pathToAnsFAQ) {
                        return $reactions.transition($temp.pathToAnsFAQ);
                    } else {
                        return $reactions.transition('/operator/Ans_PassingToOperatorPleaseWait');
                    }
            else:
                go!: /operator/Ans_PassingToOperatorPleaseWait

    state: NewState
        a: Новый текст
        go!: /FAQ/Ans4_CantDeleteProfileInApp

    state: тестируем интеграции
        buttons:
            "Да" -> /FAQ/Ans4_HowToPayBill
            "Нет" -> /FAQ/Ans4_HowToDeplugAutoinformer
        intent: /sys/aimylogic/ru/agreement || toState = "/FAQ/Ans4_HowToPayBill"
        intent: /sys/aimylogic/ru/negation || toState = "/FAQ/Ans4_HowToDeplugAutoinformer"
        event: noMatch || toState = "./"

    state: NewState_1
        q: приветбот

    state: Это тестовый стейт
        script:
            var x = 'абракадабра'
        a: {x} Это просто переменная