package beeasy.android_mvc_sample.model

import beeasy.android_mvc_sample.model.data.DetailData
import java.text.SimpleDateFormat
import java.util.*

class DetailDataList {

    internal var detailData: DetailData
            = DetailData("BeEasy"
        , Date().toString()
        ,"BeEasy@Beasy.com"
        ,"https://en.wikipedia.org/wiki/Model–view–controller"
        ,"Model–view–controller (usually known as MVC) is a software design pattern commonly used for developing user interfaces that divides the related program logic into three interconnected elements. This is done to separate internal representations of information from the ways information is presented to and accepted from the user. This kind of pattern is used for designing the layout of the page.")
}