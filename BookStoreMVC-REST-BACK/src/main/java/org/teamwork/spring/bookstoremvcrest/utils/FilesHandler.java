package org.teamwork.spring.bookstoremvcrest.utils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesHandler {
    public static String saveFile(String path, byte[] bytes) throws IOException {
        path = renameFile(path);


//        FileOutputStream photoOS = new FileOutputStream(path);
//        photoOS.write(bytes);
//        photoOS.flush();
//        photoOS.close();

        //or (much faster and easier)
        Path savePath = Paths.get(path);
        Files.write(savePath, bytes);

        return getFileNameFromPath(path);
    }

    public static String renameFile(String path) {
        File file = new File(path);
        if (file.exists()){
            String[] pathParts = path.split("\\/");
            String fileName = pathParts[pathParts.length-1];
            String[] fileNameParts = fileName.split("\\.");

            fileNameParts[fileNameParts.length-2]+="-"+System.currentTimeMillis();

            StringBuilder finalPath = new StringBuilder();

            for(int i=0; i< pathParts.length-1; i++){
                finalPath.append(pathParts[i] + "/");
            }

            finalPath.append(fileNameParts[0]);
            for(int i=1; i< fileNameParts.length; i++){
                finalPath.append("."+fileNameParts[i]);
            }
            path = finalPath.toString();
        }

        return path;
    }

    public static String getFileNameFromPath(String path){
        String[] pathParts = path.split("\\/");
        return pathParts[pathParts.length-1];
    }

    public static String deleteFile(String path) {
        File file = new File(path);

        if(file.exists() && file.isFile() && !file.getName().equals("Placeholder.png")) {
            String deletedFileName = file.getName();
            file.delete();
            return deletedFileName;
        }
        return null;
    }

    public static String updateFile(String oldFileName, String newFileName, byte[] newFile) throws IOException {
//        System.out.println(oldFileName);
//        System.out.println(newFileName);
//        System.out.println(newFile);

        FilesHandler.deleteFile(oldFileName);
        return FilesHandler.saveFile(newFileName, newFile);
    }
}
