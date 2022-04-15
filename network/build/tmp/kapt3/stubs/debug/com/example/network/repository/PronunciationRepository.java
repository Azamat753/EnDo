package com.example.network.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/network/repository/PronunciationRepository;", "", "client", "Lcom/example/network/client/PronunciationClient$Companion;", "(Lcom/example/network/client/PronunciationClient$Companion;)V", "getPronunciations", "Ljava/util/ArrayList;", "Lcom/example/network/models/PronunciationModel;", "network_debug"})
public final class PronunciationRepository {
    private final com.example.network.client.PronunciationClient.Companion client = null;
    
    @javax.inject.Inject()
    public PronunciationRepository(@org.jetbrains.annotations.NotNull()
    com.example.network.client.PronunciationClient.Companion client) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.network.models.PronunciationModel> getPronunciations() {
        return null;
    }
}