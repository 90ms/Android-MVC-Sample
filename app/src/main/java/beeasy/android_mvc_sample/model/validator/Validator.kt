package beeasy.android_mvc_sample.model.validator

import beeasy.android_mvc_sample.model.data.AnswerData

interface Validator {

    fun isValidate(answerData: AnswerData): Boolean

}