// package com.stackroute.p2plp.service;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.stream.Stream;

// import org.bson.BsonBinarySubType;
// import org.bson.types.Binary;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.Resource;
// import org.springframework.core.io.UrlResource;
// import org.springframework.stereotype.Service;
// import org.springframework.util.FileSystemUtils;
// import org.springframework.web.multipart.MultipartFile;

// import com.stackroute.p2plp.model.LoanApplication;
// import com.stackroute.p2plp.repository.LoanApplicationRepository;

// @Service
// public class LoanApplicationService {
    
//     @Autowired
//     private LoanApplicationRepository loanApplicationRepository;
    
//     public int addLoanApplication(MultipartFile file) throws IOException {
//         LoanApplication loanApplication = new LoanApplication();
//         loanApplication.setFile(
//             new Binary(BsonBinarySubType.BINARY, file.getBytes())
//         );
//         loanApplication = loanApplicationRepository.insert(loanApplication);
//         return loanApplication.getId();
//     }

//     public LoanApplication getLoanApplication(int id) {
//         return loanApplicationRepository.findById(id).get();
//     }

// }
