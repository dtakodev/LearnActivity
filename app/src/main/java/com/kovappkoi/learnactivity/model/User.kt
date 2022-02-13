package com.kovappkoi.learnactivity.model

class User(val id: String, val ngayHetHan: Long) {
    constructor(): this("", System.currentTimeMillis())
}
/*
* sự kiện đăng nhập
* check hạn sử dụng người dùng
* cho phép sử dụng dijhc vụ hay ko
* - có -> điều hướng đến dịch vụ
* - không -> điều
*
*
* */