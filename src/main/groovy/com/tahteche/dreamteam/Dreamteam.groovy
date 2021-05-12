package com.tahteche.dreamteam

import com.tahteche.dreamteam.responses.Player
import com.tahteche.dreamteam.services.PlayersService

class Dreamteam {
    static void main(String[] args) {
        int numberOfPlayers = Integer.parseInt(args[0])
        PlayersService playersService = PlayersService.instance
        List<Player> players = playersService.getPlayers(numberOfPlayers)

        for(Player player in players) {
            println player.id
            println player.name
            println player.email
            println " "
        }

        println "::set-output name=captains-email::${players.last().email}"
    }
}