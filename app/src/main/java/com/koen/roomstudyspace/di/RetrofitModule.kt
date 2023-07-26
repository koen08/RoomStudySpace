package com.koen.roomstudyspace.di

import com.koen.roomstudyspace.BuildConfig
import com.koen.roomstudyspace.data.datastore.remote.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

private const val PROTOCOL_SSL = "SSL"
private const val DEFAULT_TIMEOUT = 120L

val retrofitModule = module {

    single {
        val okHttpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(interceptor)
        }

        val trustManager = arrayOf(object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) = Unit
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) = Unit
            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        })

        val sslContext = SSLContext.getInstance(PROTOCOL_SSL).apply {
            init(null, trustManager, SecureRandom())
        }
        val sslSocketFactory = sslContext.socketFactory

        okHttpClientBuilder
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .cache(null)
            .hostnameVerifier { _, _ -> true }
            .sslSocketFactory(sslSocketFactory, trustManager.first() as X509TrustManager)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.API_URL).build() as Retrofit
    }

    single {
        get<Retrofit>().create(UserApi::class.java) as UserApi
    }
}