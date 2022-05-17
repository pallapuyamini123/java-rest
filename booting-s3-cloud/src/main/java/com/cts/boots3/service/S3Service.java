package com.cts.boots3.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {
 @Value("${application.bucket.name}")
 private String bucketName;
 @Autowired
 private AmazonS3 s3Client; //AmazonS3-it like repository,to put file to s3bucket
    
	
   public String uploadFile(MultipartFile file)throws FileNotFoundException {
   
   System.out.println(file.getSize()+">>>>>>>>>>>>");
   File fileObj=convertMultipartFileToFile(file);
   String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
   ObjectMetadata metadata=new ObjectMetadata();
   metadata.setContentLength(fileObj.length());
   FileInputStream fis=new FileInputStream(fileObj);
   s3Client.putObject(new PutObjectRequest(bucketName,fileName,fis,metadata));
   fileObj.delete();
   return "File uploaded: "+fileName;
   
   
   }
  
private File convertMultipartFileToFile(MultipartFile file) {
 File convertedFile=new File(file.getOriginalFilename());
  try(FileOutputStream fos=new FileOutputStream(convertedFile)){
   fos.write(file.getBytes());
   }
  catch(IOException e) {
   //Log.error("error converting multipart to file",e);
  e.printStackTrace();
  }
  return convertedFile;
}
}