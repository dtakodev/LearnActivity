package com.kovappkoi.learnactivity.model

class Song(val id: String, val title: String, val sub: String, val url: String, val avt: String, val autho: String) {
    constructor() : this("", "", "", "", "", "")
}
