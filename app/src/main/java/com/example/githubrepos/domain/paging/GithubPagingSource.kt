package com.example.githubrepos.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubrepos.domain.GithubRepository
import com.example.githubrepos.domain.model.Repo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.HttpException
import java.io.IOException

class GithubPagingSource : PagingSource<Int, Repo>(), KoinComponent {

    private val githubRepository: GithubRepository by inject()

    companion object {
        private const val PAGE_SIZE = 30
        private const val INITIAL_PAGE = 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        val position = params.key ?: INITIAL_PAGE
        return try {
            val response = githubRepository.fetchData(position)
            val nextKey = if (response.items.count() < PAGE_SIZE) {
                null
            } else {
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / PAGE_SIZE)
            }
            LoadResult.Page(
                data = response.items,
                prevKey = if (position == 0) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Repo>) =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

}
