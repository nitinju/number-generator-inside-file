package com.example.demo.job;

import com.example.demo.config.ServiceProperties;
import com.example.demo.model.GenerateUUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.NonWritableChannelException;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateFile {

    private final ServiceProperties serviceProperties;

    @Async
    public void process(GenerateUUID generateUUID, UUID uuid) throws IOException, InterruptedException {
        writeToFile(generateUUID, uuid);
    }

    private void writeToFile(GenerateUUID generateUUID, UUID uuid) throws IOException, InterruptedException {

        File convertFile = new File(serviceProperties.getPath() + uuid + "_output.txt");
        convertFile.createNewFile();

        try (FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
             FileChannel channel = fileOutputStream.getChannel();
             FileLock lock = channel.lock()) {
            fileOutputStream.write(generate(generateUUID).getBytes());
            fileOutputStream.close();
        } catch (NonWritableChannelException e) {
            // handle exception
        }
    }

    private String generate(GenerateUUID generateUUID) {
        StringBuilder sb = new StringBuilder("");
        Integer start = generateUUID.getGoal() / generateUUID.getStep();
        for (int i = start; i >= 0; i--) {
            sb.append(generateUUID.getGoal());
            if (i > 0) {
                sb.append(", ");
            }
            generateUUID.setGoal(generateUUID.getGoal() - generateUUID.getStep());
        }
        return String.valueOf(sb);
    }
}
