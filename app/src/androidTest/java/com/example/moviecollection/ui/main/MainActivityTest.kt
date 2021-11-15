package com.example.moviecollection.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviecollection.R
import com.example.moviecollection.dummy.DataDummy
import com.example.moviecollection.utility.EspressoIdlingResources
import org.junit.After
import org.junit.Before

import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateMovies()
    private val dummySeries = DataDummy.generateSeries()



    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadMovies() {

        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadSeries() {
        onView(withText("TV Series")).perform(click())

        onView(withId(R.id.rv_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_series)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummySeries.size))
    }

    @Test
    fun loadMoviesDetail() {

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.img_poster_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis_detail)).check(matches(withText(dummyMovie[0].synopsis)))
        onView(withId(R.id.tv_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language)).check(matches(withText(dummyMovie[0].originLanguage)))
        onView(withId(R.id.tv_movie_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_year)).check(matches(withText(dummyMovie[0].releaseYear)))
        onView(withId(R.id.tv_vote_average)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote_average)).check(matches(withText(dummyMovie[0].voteCount.toString())))
    }

    @Test
    fun loadSeriesDetail() {
        onView(withText("TV Series")).perform(click())

        onView(withId(R.id.rv_series)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_series_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_series_title)).check(matches(withText(dummySeries[0].title)))
        onView(withId(R.id.img_poster_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis_detail_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis_detail_series)).check(matches(withText(dummySeries[0].synopsis)))
        onView(withId(R.id.tv_language_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language_series)).check(matches(withText(dummySeries[0].originLanguage)))
        onView(withId(R.id.tv_series_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_series_year)).check(matches(withText(dummySeries[0].firstEpisodeYear)))
        onView(withId(R.id.tv_series_vote_average)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_series_vote_average)).check(matches(withText(dummySeries[0].voteCount.toString())))
    }

    @Test
    fun loadMovieBookmark() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.bookmark)).perform(click())
        onView(withId(R.id.rv_movie_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie_bookmark)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.img_poster_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis_detail)).check(matches(withText(dummyMovie[0].synopsis)))
        onView(withId(R.id.tv_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language)).check(matches(withText(dummyMovie[0].originLanguage)))
        onView(withId(R.id.tv_movie_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_year)).check(matches(withText(dummyMovie[0].releaseYear)))
        onView(withId(R.id.tv_vote_average)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote_average)).check(matches(withText(dummyMovie[0].voteCount.toString())))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadSeriesBookmark(){
        onView(withText("TV Series")).perform(click())
        onView(withId(R.id.rv_series)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.bookmark_series)).perform(click())
        onView(withText("TV Series")).perform(click())
        onView(withId(R.id.rv_series_bookmark)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_series_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_series_title)).check(matches(withText(dummySeries[0].title)))
        onView(withId(R.id.img_poster_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis_detail_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis_detail_series)).check(matches(withText(dummySeries[0].synopsis)))
        onView(withId(R.id.tv_language_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language_series)).check(matches(withText(dummySeries[0].originLanguage)))
        onView(withId(R.id.tv_series_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_series_year)).check(matches(withText(dummySeries[0].firstEpisodeYear)))
        onView(withId(R.id.tv_series_vote_average)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_series_vote_average)).check(matches(withText(dummySeries[0].voteCount.toString())))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

}