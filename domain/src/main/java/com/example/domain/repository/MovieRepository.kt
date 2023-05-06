package com.example.domain.repository

import com.example.domain.model.Movie
import java.time.LocalDate
import java.time.LocalTime

object MovieRepository {
    private val movies: List<Movie> = List(25) {
        Movie(
            "android.resource://woowacourse.movie/drawable/slamdunk",
            "더 퍼스트 슬램덩크 $it",
            LocalDate.of(2023, 4, 26),
            LocalDate.of(2023, 4, 28),
            listOf(LocalTime.parse("10:00"), LocalTime.parse("12:00"), LocalTime.parse("14:00")),
            124,
            "북산고 농구부는 전국 대회에 출전해 라이벌 산왕공고와 맞붙는다. 멤버 각자가 쌓아온 성과, 그들이 짊어진 과거, 다양한 생각들이 뜨거운 코트 위에서 다시 한번 격렬하게 충돌한다." +
                "북산고 농구부는 전국 대회에 출전해 라이벌 산왕공고와 맞붙는다. 멤버 각자가 쌓아온 성과, 그들이 짊어진 과거, 다양한 생각들이 뜨거운 코트 위에서 다시 한번 격렬하게 충돌한다." +
                "북산고 농구부는 전국 대회에 출전해 라이벌 산왕공고와 맞붙는다. 멤버 각자가 쌓아온 성과, 그들이 짊어진 과거, 다양한 생각들이 뜨거운 코트 위에서 다시 한번 격렬하게 충돌한다."
        )
    }

    private val movies2: List<Movie> = List(25) {
        Movie(
            "android.resource://woowacourse.movie/drawable/slamdunk",
            "더 퍼스트 슬램덩크 $it",
            LocalDate.of(2023, 4, 26),
            LocalDate.of(2023, 4, 28),
            listOf(LocalTime.parse("12:00"), LocalTime.parse("14:00")),
            124,
            "북산고 농구부는 전국 대회에 출전해 라이벌 산왕공고와 맞붙는다. 멤버 각자가 쌓아온 성과, 그들이 짊어진 과거, 다양한 생각들이 뜨거운 코트 위에서 다시 한번 격렬하게 충돌한다." +
                "북산고 농구부는 전국 대회에 출전해 라이벌 산왕공고와 맞붙는다. 멤버 각자가 쌓아온 성과, 그들이 짊어진 과거, 다양한 생각들이 뜨거운 코트 위에서 다시 한번 격렬하게 충돌한다." +
                "북산고 농구부는 전국 대회에 출전해 라이벌 산왕공고와 맞붙는다. 멤버 각자가 쌓아온 성과, 그들이 짊어진 과거, 다양한 생각들이 뜨거운 코트 위에서 다시 한번 격렬하게 충돌한다."
        )
    }

    fun allMovies(): List<Movie> = movies.toList()
    fun allMovies2(): List<Movie> = movies2.toList()
}