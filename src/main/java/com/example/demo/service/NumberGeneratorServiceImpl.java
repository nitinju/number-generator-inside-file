package com.example.demo.service;

import com.example.demo.config.ServiceProperties;
import com.example.demo.job.CreateFile;
import com.example.demo.model.FileResponse;
import com.example.demo.model.GenerateResponse;
import com.example.demo.model.GenerateUUID;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

@Service
public class NumberGeneratorServiceImpl implements NumberGeneratorService {

    private final CreateFile createFile;
    private final ServiceProperties serviceProperties;

    public NumberGeneratorServiceImpl(CreateFile createFile, ServiceProperties serviceProperties) {
        this.createFile = createFile;
        this.serviceProperties = serviceProperties;
    }

    public GenerateResponse createFileAnd(GenerateUUID generateUUID, UUID uuid) throws IOException, InterruptedException {
        GenerateResponse generateResponse = new GenerateResponse();
        if (generateUUID.getStep() > 0 && generateUUID.getGoal() > generateUUID.getStep()) {
            generateResponse.setTask(uuid);
            createFile.process(generateUUID, uuid);
            return generateResponse;
        }
        return generateResponse;
    }

    public UUID createUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    public FileResponse checkStatus(String uuid) {
        FileResponse fileResponse = new FileResponse();
        String file = serviceProperties.getPath() + uuid + "_output.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try {
                reader.readLine();
                fileResponse.setResult("SUCCESS");
            } catch (IOException e) {
                fileResponse.setResult("IN_PROGRESS");
            }
        } catch (IOException e) {
            fileResponse.setResult("ERROR");
        }
        return fileResponse;
    }

    public FileResponse readFile(String uuid) throws IOException {
        FileResponse fileResponse = new FileResponse();
        String file = serviceProperties.getPath() + uuid + "_output.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            fileResponse.setResult(reader.readLine());
            reader.close();
        }catch (IOException e){
            fileResponse.setResult(e.getMessage());
        }
        return fileResponse;
    }
}
