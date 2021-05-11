package com.tahteche.dreamteam.responses

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Player {
    int id
    String name
    String email
    String phone
}
