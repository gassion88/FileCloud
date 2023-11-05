package com.gassion.filecloudbackend.storage.service.impl;

import com.gassion.filecloudbackend.storage.dao.FolderDAO;
import com.gassion.filecloudbackend.storage.service.FolderService;
import com.gassion.filecloudbackend.storage.web.UserBucketResponse;
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
    public List<Item> getUserBucketItems() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Iterable<Result<Item>> results =  folderDAO.getUserBucket(userId);
        List<Item> items = new ArrayList<>();

        for (Result<Item> result : results) {
            items.add(result.get()) ;
        }

        return items;
    }

    @Override
    public void createUserBucket(String userId)  {
        try {
            folderDAO.createBucket("user" + userId);
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createFolder() {

    }

    @Override
    public void deleteFolder() {

    }

    @Override
    public void renameFolder() {

    }

    @Override
    public void moveFolder() {

    }

}
