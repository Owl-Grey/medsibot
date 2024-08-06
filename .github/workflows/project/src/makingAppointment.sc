theme: /goAnsMakingAppointment
    
    state: ToMakeAppointmentCallTheOperator
        if: $parseTree._doc_specialties
            a: Для записи на приём к указанному специалисту {{funcYou("обратитесь", "обратитесь", "обратись")}} по номеру, указанному на нашем сайте.
        else: 
            go!: /operator/Ans_PassingToOperatorPleaseWait

    state: NewState