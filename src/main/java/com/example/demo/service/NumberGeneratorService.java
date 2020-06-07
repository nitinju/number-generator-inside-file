package com.example.demo.service;

import com.example.demo.model.FileResponse;
import com.example.demo.model.GenerateResponse;
import com.example.demo.model.GenerateUUID;

import java.io.IOException;
import java.util.UUID;

public interface NumberGeneratorService {

    public abstract GenerateResponse createFileAnd(GenerateUUID generateUUID, UUID uuid) throws IOException, InterruptedException;
    public abstract UUID createUUID();
    public abstract FileResponse checkStatus(String uuid);
    public abstract FileResponse readFile(String uuid) throws IOException;
}
