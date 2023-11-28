package com.gassion.filecloudbackend.storage.service.impl;

import com.gassion.filecloudbackend.storage.dao.FolderDAO;
import com.gassion.filecloudbackend.storage.service.FolderService;
import io.minio.messages.Item;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FolderServiceImpl implements FolderService {

    private final FolderDAO folderDAO;

    public FolderServiceImpl(FolderDAO folderDAO) {
        this.folderDAO = folderDAO;
    }

    @Override
    public List<Item> getUserBucketItems(String userId) {
        return folderDAO.getUserBucket(userId);
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
    public void renameFolder(String bucket, String source, String newName) {
        folderDAO.copyFolder(bucket, source, newName);
        folderDAO.deleteFolder(bucket, source);
    }

    @Override
    public void moveFolder(String bucket, @NotBlank String source, @NotBlank String target) {
        folderDAO.copyFolder(bucket, source, target);
        folderDAO.deleteFolder(bucket, source);
    }

    @Override
    public void copyFolder(String bucket, String sourceFolder, String targetFolder) {
        folderDAO.copyFolder(bucket, sourceFolder, targetFolder);
    }
}
