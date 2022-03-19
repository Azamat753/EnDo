package com.example.network.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/network/repository/TranslationRepository;", "Lcom/example/core/utils/ResultWrapper;", "translationApi", "Lcom/example/network/api/TranslationApi;", "(Lcom/example/network/api/TranslationApi;)V", "getTranslate", "Lcom/example/core/utils/Response;", "Lcom/example/network/models/translation/TranslationModel;", "wordInEnglish", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"})
public final class TranslationRepository extends com.example.core.utils.ResultWrapper {
    private final com.example.network.api.TranslationApi translationApi = null;
    
    @javax.inject.Inject()
    public TranslationRepository(@org.jetbrains.annotations.NotNull()
    com.example.network.api.TranslationApi translationApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTranslate(@org.jetbrains.annotations.NotNull()
    java.lang.String wordInEnglish, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.core.utils.Response<com.example.network.models.translation.TranslationModel>> continuation) {
        return null;
    }
}