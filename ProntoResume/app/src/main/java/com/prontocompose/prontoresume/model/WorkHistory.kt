package com.prontocompose.prontoresume.model

import com.prontocompose.prontoresume.R

data class WorkHistory(
    val companyName: String,
    val position: String,
    val summary: String,
    val skills: List<Skill>,
    val startDate: String,
    val endDate: String,
    val logoId: Int
)


fun sampleWorkHistories() = listOf(
    WorkHistory(
        "Data Systems, Inc",
        "Lead Software Engineer",
        "Carefully designed, tested and built new products and features" +
                " that resolved issues and advances software.",
        listOf(
            Skill("Java"),
            Skill("Kotlin"),
            Skill("C#"),
            Skill("Java Script")
        ),
        "May 2011",
        "Jan 2021",
        R.drawable.ic_sample_logo_2
    ),
    WorkHistory(
        "LandLogix, Inc",
        "Senior Software Engineer",
        "Worked to meet the specific needs of clients through groundbreaking " +
                "software solutions.Built cutting edge tools and applications to meet strategic business goals",
        listOf(
            Skill("Java"),
            Skill("Kotlin"),
            Skill("C#"),
            Skill("Java Script")
        ),
        "Nov 2008",
        "April 2011",
        R.drawable.ic_sample_logo_4
    ),
    WorkHistory(
        "Contoso Corporation",
        "Software Engineer",
        "Developed and maintained documentation related to software " +
                "processes and systems, including requirements and design documentation.",
        listOf(
            Skill("Java"),
            Skill("Kotlin"),
            Skill("C#"),
            Skill("Java Script")
        ),
        "March 2005",
        "Sept. 2008",
        R.drawable.ic_sample_logo_1
    )
)