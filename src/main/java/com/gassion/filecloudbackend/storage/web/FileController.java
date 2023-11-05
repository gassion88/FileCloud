package com.gassion.filecloudbackend.storage.web;

import com.gassion.filecloudbackend.security.api.service.IdentityApiService;
import com.gassion.filecloudbackend.storage.mapper.BucketItemToUserBucketResponseMapper;
import com.gassion.filecloudbackend.storage.service.FolderService;
import com.gassion.filecloudbackend.storage.web.dto.CreateFolderRequest;
import com.gassion.filecloudbackend.storage.web.dto.UserBucketResponse;
import io.minio.errors.*;
import io.minio.messages.Item;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
}