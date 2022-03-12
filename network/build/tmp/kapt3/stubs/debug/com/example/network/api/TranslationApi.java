package com.example.network.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J]\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\r\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/network/api/TranslationApi;", "", "searchTranslation", "Lretrofit2/Response;", "Lcom/example/network/models/translation/TranslationModel;", "langPair", "", "wordInEnglish", "mt", "", "onlyPrivate", "de", "header1", "header2", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"})
public abstract interface TranslationApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/api/get")
    public abstract java.lang.Object searchTranslation(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "langpair")
    java.lang.String langPair, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String wordInEnglish, @retrofit2.http.Query(value = "mt")
    int mt, @retrofit2.http.Query(value = "onlyprivate")
    int onlyPrivate, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "de")
    java.lang.String de, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "x-rapidapi-host")
    java.lang.String header1, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "x-rapidapi-key")
    java.lang.String header2, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.network.models.translation.TranslationModel>> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}