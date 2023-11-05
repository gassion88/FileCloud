package com.gassion.filecloudbackend.storage.service.impl;

import com.gassion.filecloudbackend.storage.dao.FolderDAO;
import com.gassion.filecloudbackend.storage.service.FolderService;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Item;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FolderServiceImpl implements FolderService {

    private final FolderDAO folderDAO;

    public FolderServiceImpl(FolderDAO folderDAO) {
        this.folderDAO = folderDAO;
    }

    @Override
    public List<Item> getUserBucketItems(String userId) {
        Iterable<Result<Item>> results =  folderDAO.getUserBucket(userId);
        List<Item> items = new ArrayList<>();

        try {
            for (Result<Item> result : results) {

                items.add(result.get());
            }
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException |
                 XmlParserException e) {
            throw new RuntimeException(e);
        }

        return items;
    }

    @Override
    public void createUserBucket(String userId)  {
            folderDAO.createBucket("user" + userId);
    }

    @Override
    public void createFolder(String bucket, String path) {
            folderDAO.createFolder(bucket, path);
    }

    @Override
    public void deleteFolder(String bucket, String path) {
        folderDAO.deleteFolder(bucket, path);
    }

    @Override
    public void renameFolder() {

    }

    @Override
    public void moveFolder() {

    }

}
