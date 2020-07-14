package beeasy.android_mvc_sample.model.validator

import beeasy.android_mvc_sample.model.data.AnswerData

class AnswerValidator : Validator {

    private val userCredential = AnswerData("mvc")

    override fun isValidate(answerData: AnswerData): Boolean {
        return answerData == userCredential
    }

}