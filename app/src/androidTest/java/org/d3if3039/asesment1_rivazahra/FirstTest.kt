package org.d3if3039.asesment1_rivazahra


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class FirstTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(SplashActivity::class.java)

    @Test
    fun firstTest() {
        val textInputEditText = onView(
            allOf(
                withId(R.id.pencarian_inp),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText.perform(scrollTo(), click())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.pencarian_inp),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText2.perform(scrollTo(), click())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.pencarian_inp),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText3.perform(scrollTo(), click())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.pencarian_inp),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText4.perform(scrollTo(), click())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.pencarian_inp),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText5.perform(scrollTo(), click())

        val textInputEditText6 = onView(
            allOf(
                withId(R.id.pencarian_inp),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.textInputLayout),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText6.perform(scrollTo(), replaceText("pasta"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.buttonCari), withText("Cari"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    2
                )
            )
        )
        materialButton.perform(scrollTo(), click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
