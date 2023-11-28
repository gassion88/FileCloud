package com.gassion.filecloudbackend.storage.dao.impl;

import com.gassion.filecloudbackend.storage.dao.FolderDAO;
import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Item;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FolderDAOImpl implements FolderDAO {

    private final MinioClient minioClient;

    public FolderDAOImpl(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public List<Item> getUserBucket(String bucket) {
        Iterable<Result<Item>> results =  minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucket).recursive(true).build());

        List<Item> items = new ArrayList<>();

        for (Result<Item> result : results) {
            try {
                items.add(result.get());
            } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                     InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException |
                     XmlParserException e) {
                throw new RuntimeException(e);
            }
        }

        return items;
    }

    @Override
    public void createBucket(String bucketName) {
        try {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(bucketName)
                            .build());

        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException |
                 XmlParserException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createFolder(String bucket, String path) {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucket).object(path).stream(
                                    new ByteArrayInputStream(new byte[] {}), 0, -1)
                            .build());
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException |
                 XmlParserException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteFolder(String bucket, String path) {
        try {
        minioClient.removeObject(
                RemoveObjectArgs.builder().bucket(bucket).object(path).build());
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException |
                XmlParserException e) {
        throw new RuntimeException(e);
        }
    }

    @Override
    public void copyFolder(String bucket, String sourceFolder, String targetFolder) {
        try {
            minioClient.copyObject(
                    CopyObjectArgs.builder()
                            .bucket(bucket)
                            .object(targetFolder)
                            .source(
                                    CopySource.builder()
                                            .bucket(bucket)
                                            .object(sourceFolder)
                                            .build())
                            .build());
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException |
                 XmlParserException e) {
            throw new RuntimeException(e);
        }
    }

}
