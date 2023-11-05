package com.gassion.filecloudbackend.storage.mapper;

import com.gassion.filecloudbackend.common.mapper.Mapper;
import com.gassion.filecloudbackend.storage.web.dto.UserBucketResponse;
import io.minio.messages.Item;

import java.util.List;

public interface BucketItemToUserBucketResponseMapper extends Mapper<UserBucketResponse, List<Item>> {
}
