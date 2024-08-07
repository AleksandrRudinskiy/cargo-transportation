package com.cargotrasportation.loading;

public interface LoadingService {
    Loading addLoading(long userId, Loading loading, long cargoId, long transportId);
}
