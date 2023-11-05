package com.gassion.filecloudbackend.storage.web;

import com.gassion.filecloudbackend.storage.mapper.BucketItemToUserBucketResponseMapper;
import com.gassion.filecloudbackend.storage.service.FolderService;
import io.minio.errors.*;
import io.minio.messages.Item;
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

    private final BucketItemToUserBucketResponseMapper bucketItemMapper;

    public FileController(FolderService folderService, BucketItemToUserBucketResponseMapper bucketItemMapper) {
        this.folderService = folderService;
        this.bucketItemMapper = bucketItemMapper;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public UserBucketResponse getUserBucket() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        List<Item> userItems = folderService.getUserBucketItems();
        return bucketItemMapper.map(userItems);
    }

}