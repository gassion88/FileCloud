package com.gassion.filecloudbackend.storage.web;

import com.gassion.filecloudbackend.security.api.service.IdentityApiService;
import com.gassion.filecloudbackend.storage.mapper.BucketItemToUserBucketResponseMapper;
import com.gassion.filecloudbackend.storage.service.FolderService;
import com.gassion.filecloudbackend.storage.web.dto.*;
import io.minio.messages.Item;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    private final FolderService folderService;

    private final IdentityApiService identityApiService;

    private final BucketItemToUserBucketResponseMapper bucketItemMapper;

    public FileController(FolderService folderService, IdentityApiService identityApiService, BucketItemToUserBucketResponseMapper bucketItemMapper) {
        this.folderService = folderService;
        this.identityApiService = identityApiService;
        this.bucketItemMapper = bucketItemMapper;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public UserBucketResponse getUserBucket()  {
        String userBucketName = "user" + identityApiService.getCurrentUserAccount().get().currentUserAccountId();
        List<Item> userItems = folderService.getUserBucketItems(userBucketName);
        return bucketItemMapper.map(userItems);
    }

    @PutMapping("/folder")
    @ResponseStatus(HttpStatus.OK)
    public UserBucketResponse createNewFolder(@Valid @RequestBody CreateFolderRequest createFolderRequest)  {
        String userBucketName = "user" + identityApiService.getCurrentUserAccount().get().currentUserAccountId();
        folderService.createFolder(userBucketName, createFolderRequest.path());

        List<Item> userItems = folderService.getUserBucketItems(userBucketName);
        return bucketItemMapper.map(userItems);
    }

    @DeleteMapping ("/folder")
    @ResponseStatus(HttpStatus.OK)
    public UserBucketResponse deleteFolder(@Valid @RequestBody DeleteFolderRequest deleteFolderRequest)  {
        String userBucketName = "user" + identityApiService.getCurrentUserAccount().get().currentUserAccountId();
        folderService.deleteFolder(userBucketName, deleteFolderRequest.path());

        List<Item> userItems = folderService.getUserBucketItems(userBucketName);
        return bucketItemMapper.map(userItems);
    }

    @PutMapping("/folder_copy")
    @ResponseStatus(HttpStatus.OK)
    public UserBucketResponse copyFolder(@Valid @RequestBody CopyFolderRequest copyFolderRequest)  {
        String userBucketName = "user" + identityApiService.getCurrentUserAccount().get().currentUserAccountId();
        folderService.copyFolder(userBucketName, copyFolderRequest.source(), copyFolderRequest.target());

        List<Item> userItems = folderService.getUserBucketItems(userBucketName);
        return bucketItemMapper.map(userItems);
    }

    @PutMapping("/folder_move")
    @ResponseStatus(HttpStatus.OK)
    public UserBucketResponse moveFolder(@Valid @RequestBody MoveFolderRequest moveFolderRequest)  {
        String userBucketName = "user" + identityApiService.getCurrentUserAccount().get().currentUserAccountId();
        folderService.moveFolder(userBucketName, moveFolderRequest.source(), moveFolderRequest.target());

        List<Item> userItems = folderService.getUserBucketItems(userBucketName);
        return bucketItemMapper.map(userItems);
    }

    @PutMapping("/folder_rename")
    @ResponseStatus(HttpStatus.OK)
    public UserBucketResponse renameFolder(@Valid @RequestBody RenameFolderRequest moveFolderRequest)  {
        String userBucketName = "user" + identityApiService.getCurrentUserAccount().get().currentUserAccountId();
        folderService.renameFolder(userBucketName, moveFolderRequest.source(), moveFolderRequest.newName());

        List<Item> userItems = folderService.getUserBucketItems(userBucketName);
        return bucketItemMapper.map(userItems);
    }
}