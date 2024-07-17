package com.example.basicstatecodelab

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes

data class AlignYourBodyItem(
    val drawable: Int,
    val text: Int,
    val description: Int
)
val AlignYourBodyData = listOf(
    AlignYourBodyItem(
        drawable = R.drawable.inversion,
        text = R.string.inversions,
        description = R.string.Inversions_desc
    ),
    AlignYourBodyItem(
        drawable = R.drawable.quickyoga,
        text = R.string.quickyoga,
        description = R.string.quickyoga_desc
    ),
    AlignYourBodyItem(
        drawable = R.drawable.stretching,
        text = R.string.stretching,
        description = R.string.stretching_desc
    ),
    AlignYourBodyItem(
        drawable = R.drawable.tabata,
        text = R.string.tabata,
        description = R.string.tabata_desc
    ),
    AlignYourBodyItem(
        drawable = R.drawable.hiit,
        text = R.string.hiit,
        description = R.string.hiit_desc
    ),
    AlignYourBodyItem(
        drawable = R.drawable.prenatal_yoga,
        text = R.string.prenatal_yoga,
        description = R.string.prenatalyoga_desc
    )
)

data class favouriteCollectionItem(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int,
    @RawRes val audioRes: Int
)


val favouriteCollectionsData = listOf(
    favouriteCollectionItem(
        drawable = R.drawable.short_mantras,
        text = R.string.short_mantras,
        audioRes = R.raw.shortmantras
    ),
    favouriteCollectionItem(
        drawable = R.drawable.nature_meditation,
        text = R.string.nature_meditation,
        audioRes = R.raw.naturemeditation
    ),
    favouriteCollectionItem(
        drawable = R.drawable.stress_and_anxiety,
        text = R.string.stress_and_anxiety,
        audioRes = R.raw.stressandanxiety
    ),
    favouriteCollectionItem(
        drawable = R.drawable.self_massage,
        text = R.string.self_massage,
        audioRes = R.raw.selfmassage
    ),
    favouriteCollectionItem(
        drawable = R.drawable.overwhelmed,
        text = R.string.overwhelmed,
        audioRes = R.raw.overwhelmed
    ),
    favouriteCollectionItem(
        drawable = R.drawable.nightimage,
        text = R.string.nightimage,
        audioRes = R.raw.nightlywinddown
    )
)

data class Setting(
    val title: String,
    val subItems: List<String>
)

val settingsData = listOf(
    Setting(
        "Account Settings", listOf(
            "Profile Information",
            "Password Management"
        )
    ),
    Setting(
        "Privacy and Security", listOf(
            "Two-Factor Authentication"
        )
    ),
    Setting(
        "Display and Appearance", listOf(
            "Theme (Light/Dark Mode)"
        )
    ),
    Setting(
        "Language", listOf(
            "Preferred Language",
            "Regional Settings"
        )
    ),
    Setting(
        "Support and Feedback", listOf(
            "Report a Problem",
            "Submit Feedback"
        )
    )
)