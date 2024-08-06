theme: /operator
    

    state: Ans_PassingToOperatorPleaseWait || sessionResult = "Перевод на оператора", sessionResultColor = "#7524AA"
        script:
            $reactions.answer("Перевожу на оператора Пожалуйста, " + funcYou("ожидайте", "ожидайте", "ожидай") + ".");

    state: NewState