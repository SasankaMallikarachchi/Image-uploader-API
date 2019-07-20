package com.example.imageUploader.exception;

public class ImageStorageException extends RuntimeException {

    public ImageStorageException() {
        super();
    }

    public ImageStorageException(String message) {
        super(message);
    }
}
