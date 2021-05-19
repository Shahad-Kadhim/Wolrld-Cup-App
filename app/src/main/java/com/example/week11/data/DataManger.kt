package com.example.week11.data

import com.example.week11.data.domain.Match

object DataManger {
    private val matchList= mutableListOf<Match>()
    private var index=0
    fun addMatch(match: Match){
        matchList.add(match)
    }
    fun getCurrentMatch()= matchList[index]
    fun getNextMatch():Match{
        index++
        takeIf {index== matchList.size}?.let { index=0 }
        return getCurrentMatch()
    }
    fun getPreviousMatch():Match{
        index--
        takeIf {index== -1}?.let { index= matchList.lastIndex }
        return getCurrentMatch()
    }
}