package beeasy.android_mvc_sample.model

import beeasy.android_mvc_sample.model.validator.AnswerValidator

object ModelModule {

    val dataAccessLayer : DataAccessLayer by lazy { dataAccessLayer() }

    private fun dataAccessLayer() = DataAccessLayer(AnswerValidator(), DetailDataList())
}