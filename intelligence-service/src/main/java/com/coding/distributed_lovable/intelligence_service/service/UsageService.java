package com.coding.distributed_lovable.intelligence_service.service;

public interface UsageService {

    public void recordTokenUsage(Long userId, int actualTokens);
    public void checkDailyTokenUsage();
}
