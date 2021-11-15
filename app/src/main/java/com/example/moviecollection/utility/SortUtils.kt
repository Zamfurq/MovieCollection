package com.example.moviecollection.utility

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {
    const val ASCENDING = "ascending"
    const val DESCENDING = "descending"
    const val DEFAULT = "default"

    fun getSortedQueryMovies(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM movieentities ")
        if (filter == ASCENDING) {
            simpleQuery.append("ORDER BY title ASC")
        } else if (filter == DESCENDING) {
            simpleQuery.append("ORDER BY title DESC")
        } else if (filter == DEFAULT) {
            simpleQuery.append("")
        }
        return  SimpleSQLiteQuery(simpleQuery.toString())
    }

    fun getSortedQuerySeries(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM seriesentities ")
        if (filter == ASCENDING) {
            simpleQuery.append("ORDER BY title ASC")
        } else if (filter == DESCENDING) {
            simpleQuery.append("ORDER BY title DESC")
        } else if (filter == DEFAULT) {
            simpleQuery.append("")
        }
        return  SimpleSQLiteQuery(simpleQuery.toString())
    }
}