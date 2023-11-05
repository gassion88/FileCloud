package com.gassion.filecloudbackend.storage.dao;

import io.minio.Result;
import io.minio.messages.Item;

public interface FolderDAO {

    Iterable<Result<Item>> getUserBucket(String bucket);
}
