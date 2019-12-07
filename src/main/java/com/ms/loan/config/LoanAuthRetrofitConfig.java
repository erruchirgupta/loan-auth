package com.ms.loan.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.loan.service.ApiService;
import com.ms.loan.service.AutoAssignService;

import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
@Slf4j
public class LoanAuthRetrofitConfig {
	
	private static final String HEADER_CONTENT_TYPE = "Content-Type";
	private static final String HEADER_CONTENT_TYPE_VAL = "application/json";
	private static final String IBM_CLIENT_SECRET = "X-IBM-Client-secret";
	private static final String IBM_CLIENT_ID = "X-IBM-Client-Id";
    private static final String AUTHORIZATION = "Authorization";

    private static final int MAX_IDLE_CONNECTIONS = 50;
    private static final int KEEP_ALIVE_DURATION = 50;
    private static final int MAX_REQUESTS = 500;
    private static final int MAX_REQUESTS_PER_HOST = 50;
    
    @Autowired
    private LoanAuthWebServiceConfig loanAuthRetrofitConfig;
   
    @Bean
    public ApiService getApiService() throws Exception {
    	log.info("URL : {}", loanAuthRetrofitConfig.getUrl());
        ConnectionPool connectionPool = new ConnectionPool(MAX_IDLE_CONNECTIONS, KEEP_ALIVE_DURATION, TimeUnit.MINUTES);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(MAX_REQUESTS);
        dispatcher.setMaxRequestsPerHost(MAX_REQUESTS_PER_HOST);
    	
        return new Retrofit.Builder()
            .baseUrl(loanAuthRetrofitConfig.getUrl())
            .addConverterFactory(JacksonConverterFactory.create())
            .client(new OkHttpClient.Builder()
                    .connectTimeout(2, TimeUnit.MINUTES)
                    .readTimeout(2, TimeUnit.MINUTES)
                    .writeTimeout(2, TimeUnit.MINUTES)
                    .connectionPool(connectionPool)
                    .dispatcher(dispatcher)
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(chain -> {
                		return chain.proceed(chain.request().newBuilder()
                				.addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VAL)
                				.addHeader(IBM_CLIENT_SECRET, loanAuthRetrofitConfig.getClientSecret())
                				.addHeader(IBM_CLIENT_ID, loanAuthRetrofitConfig.getClientId())
                				.addHeader(AUTHORIZATION, loanAuthRetrofitConfig.getAuth())
                				.method(chain.request().method(), chain.request().body())
                				.build());})
                    .build())
            .build()
            .create(ApiService.class);
    }
    
    @Bean
    public AutoAssignService getAutoAssignService() throws Exception {
        ConnectionPool connectionPool = new ConnectionPool(MAX_IDLE_CONNECTIONS, KEEP_ALIVE_DURATION, TimeUnit.MINUTES);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(MAX_REQUESTS);
        dispatcher.setMaxRequestsPerHost(MAX_REQUESTS_PER_HOST);
    	
        return new Retrofit.Builder()
            .baseUrl(loanAuthRetrofitConfig.getUrl())
            .addConverterFactory(JacksonConverterFactory.create())
            .client(new OkHttpClient.Builder()
                    .connectTimeout(2, TimeUnit.MINUTES)
                    .readTimeout(2, TimeUnit.MINUTES)
                    .writeTimeout(2, TimeUnit.MINUTES)
                    .connectionPool(connectionPool)
                    .dispatcher(dispatcher)
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(chain -> {
                		return chain.proceed(chain.request().newBuilder()
                				.addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VAL)
                				.addHeader(IBM_CLIENT_SECRET, loanAuthRetrofitConfig.getClientSecret())
                				.addHeader(IBM_CLIENT_ID, loanAuthRetrofitConfig.getClientId())
                				.addHeader(AUTHORIZATION, loanAuthRetrofitConfig.getAuth())
                				.method(chain.request().method(), chain.request().body())
                				.build());})
                    .build())
            .build()
            .create(AutoAssignService.class);
    }
}
