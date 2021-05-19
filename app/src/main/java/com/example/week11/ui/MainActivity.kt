package com.example.week11.ui

import android.view.LayoutInflater
import com.example.week11.data.DataManger
import com.example.week11.data.domain.Match
import com.example.week11.databinding.ActivityMainBinding
import com.example.week11.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val LOG_TAG: String="MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding= ActivityMainBinding::inflate
    override fun setUp() {
        parseFile()
    }
    override fun callback() {
        binding?.apply {
            beforeBtn.setOnClickListener {
                bindMatch(DataManger.getPreviousMatch())
            }
            nextBtn.setOnClickListener {
                bindMatch(DataManger.getNextMatch())
            }
        }
    }
    private fun parseFile(){
        val inputStream=assets.open("worldcup.csv")
        val buffer=BufferedReader(InputStreamReader(inputStream))
        buffer.forEachLine {
            DataManger.addMatch(CsvParser.parse(it))
        }
        bindMatch(DataManger.getCurrentMatch())
    }
    private fun bindMatch(match: Match){
        binding?.apply {
            homeTeamName.text=match.homeTeamName
            awayTeamName.text=match.awayTeamName
            awayTeamGoals.text=match.awayTeamGoals.toString()
            homeTeamGoals.text=match.homeTeamGoals.toString()
            yearOfMatch.text=match.year.toString()
            stadiumName.text=match.stadium
        }
    }
}