package com.gassion.filecloudbackend.storage.mapper.impl;

import com.gassion.filecloudbackend.storage.mapper.BucketItemToUserBucketResponseMapper;
import com.gassion.filecloudbackend.storage.model.BucketFile;
import com.gassion.filecloudbackend.storage.web.dto.UserBucketResponse;
import io.minio.messages.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BucketItemToUserBucketResponseMapperImpl implements BucketItemToUserBucketResponseMapper {

    @Override
    public UserBucketResponse map(List<Item> source) {
        UserBucketResponse userBucketResponse = new UserBucketResponse(new ArrayList<>());

        for (Item item : source) {
            BucketFile bucketFile = new BucketFile(item.objectName(),
                    item.size(),
                    item.lastModified());

            userBucketResponse.userFiles().add(bucketFile);
        }

        return userBucketResponse;
    }
}
