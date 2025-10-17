package ru.noxis.common.di.context

import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DispatchersImpl @Inject constructor(): Dispatchers {
    override val main: CoroutineContext
        get() = kotlinx.coroutines.Dispatchers.Main
    override val default: CoroutineContext
        get() = kotlinx.coroutines.Dispatchers.Default
    override val unconfined: CoroutineContext
        get() = kotlinx.coroutines.Dispatchers.Unconfined
    override val io: CoroutineContext
        get() = kotlinx.coroutines.Dispatchers.IO
    @OptIn(ExperimentalCoroutinesApi::class)
    override val log: CoroutineContext
        get() = kotlinx.coroutines.Dispatchers.IO.limitedParallelism(1)

}