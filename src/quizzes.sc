theme: /goAnsQuizzes

    state: Ans_CanIHelpMore
        a: Могу я чем-то ещё {{funcYou("Вам", "вам", "тебе")}} помочь?
        buttons:
            "Да"
        buttons:
            "Нет"
        buttons:
            "Обратиться к оператору"

        state: react_YES
            intent: /sys/aimylogic/ru/agreement
            go!: /Ans_SpecifyWhatUInterestedInGeneral


        state: react_NO
            intent: /sys/aimylogic/ru/offerreject
            go!: /Ans4_Goodbye


