package beeasy.android_mvc_sample.model

import beeasy.android_mvc_sample.model.data.AnswerData
import beeasy.android_mvc_sample.model.observer.AccessObserver
import beeasy.android_mvc_sample.model.validator.Validator

class DataAccessLayer(private val userValidator: Validator, private val detailDataList: DetailDataList){

    private val observers = mutableListOf<AccessObserver>()

    fun register(observer: AccessObserver) = observers.add(observer)

    fun unregister(observer: AccessObserver) = observers.remove(observer)

    fun checkAnswer(answerData : String){
        val credential = AnswerData(answerData)

        if(userValidator.isValidate(credential)){
            notify(AccessObserver::onSuccess)
        } else {
            notify(AccessObserver::onFail)
        }
    }

    private fun notify(action: (AccessObserver) -> Unit) {
        //observers.filterIsInstance<AccessObserver>().onEach { action(it) }
        observers.onEach { action(it) }
    }

    fun getCurrentAccount() = detailDataList.detailData
}