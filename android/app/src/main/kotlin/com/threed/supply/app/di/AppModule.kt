package com.threed.supply.app.di

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import com.threed.supply.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

@Module
abstract class AppModule {

    @Binds
    internal abstract fun context(application: Application): Context

    @Module
    companion object {

        @Provides
        @JvmStatic
        @ApplicationScope
        internal fun resources(application: Application): Resources {
            return application.resources
        }

        @Provides
        @JvmStatic
        @ApplicationScope
        internal fun picasso(context: Context, okHttpDownloader: OkHttp3Downloader): Picasso {
            return Picasso.Builder(context).downloader(okHttpDownloader).build()
        }

        @Provides
        @JvmStatic
        @ApplicationScope
        internal fun okHttpDownloader(okHttpClient: OkHttpClient): OkHttp3Downloader {
            return OkHttp3Downloader(okHttpClient)
        }

        @Provides
        @JvmStatic
        @ApplicationScope
        internal fun okHttpClient(
            loggingInterceptor: HttpLoggingInterceptor,
            cache: Cache
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build()
        }

        @Provides
        @JvmStatic
        @ApplicationScope
        internal fun httpLoggingInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor { message -> Log.d("", message) }
            interceptor.level = HttpLoggingInterceptor.Level.BASIC
            return interceptor
        }

        @Provides
        @JvmStatic
        @ApplicationScope
        internal fun cache(cacheFile: File): Cache {
            return Cache(cacheFile, (10 * 1000 * 1000).toLong())
        }

        @Provides
        @JvmStatic
        @ApplicationScope
        internal fun file(context: Context): File {
            return File(context.cacheDir, "taxi_cache")
        }
    }
}
