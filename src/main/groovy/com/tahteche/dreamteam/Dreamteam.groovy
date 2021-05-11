package com.tahteche.dreamteam

import com.tahteche.dreamteam.services.PlayersService

class Dreamteam {
    static void main(String[] args) {
        int numberOfPlayers = Integer.parseInt(args[0])
        PlayersService playersService = PlayersService.instance
        def players = playersService.getPlayers(numberOfPlayers)
        println players
    }
}