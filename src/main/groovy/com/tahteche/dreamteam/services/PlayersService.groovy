package com.tahteche.dreamteam.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.core.type.TypeReference
import org.apache.hc.client5.http.fluent.Request
import com.tahteche.dreamteam.responses.Player

@Singleton
class PlayersService {
    String url = "https://jsonplaceholder.typicode.com/users"
    ObjectMapper objectMapper = new ObjectMapper()

    List<Player> getPlayers(int numberOfPlayers = 10) {
        List<Player> players = objectMapper.readValue(Request.get(this.url).execute().returnContent().toString(), new TypeReference<List<Player>>() {})
        return players.subList(0, numberOfPlayers)
    }
}
