package com.example.week11.util

import com.example.week11.data.domain.Match

object CsvParser {
    fun parse(line:String):Match{
        val token =line.split(',')
        return Match(
                year = token[Constant.ColumnIndex.YEAR].toInt(),
                stadium= token[Constant.ColumnIndex.STADIUM] ,
                city= token[Constant.ColumnIndex.CITY] ,
                homeTeamName= token[Constant.ColumnIndex.HOME_TEAM_NAME] ,
                awayTeamName= token[Constant.ColumnIndex.AWAY_TEAM_NAME],
                awayTeamGoals= token[Constant.ColumnIndex.AWAY_TEAM_GOALS].toInt(),
                homeTeamGoals= token[Constant.ColumnIndex.HOME_TEAM_GOALS].toInt()
        )
    }
}