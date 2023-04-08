package com.example.footballfriends.leagues.presentation

/**
 * @author Kirilin Yury on 08.04.2023.
 */
sealed class LeaguesViewState {
    object Loading : LeaguesViewState()
    object Error : LeaguesViewState()
    data class ContentLeagues(
        val leagues: MutableList<CompetitionXViewState>
    ) : LeaguesViewState()
}