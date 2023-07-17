// package com.stackroute.p2plp.controller;

// import java.io.IOException;
// import java.util.Base64;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;

// import com.stackroute.p2plp.model.Loan;
// import com.stackroute.p2plp.model.LoanApplication;
// import com.stackroute.p2plp.service.LoanApplicationService;



// @RestController
// public class LoanApplicationController {
    
//     @Autowired
//     private LoanApplicationService loanApplicationService;
//     private ResponseEntity<?> responseEntity;

//     @PostMapping("/loanApplication")
//     public ResponseEntity<?> addLoanApplication(@RequestParam("file") MultipartFile file) throws IOException{
//         try {
//             responseEntity = ResponseEntity.ok(loanApplicationService.addLoanApplication(file));
//         } catch (Exception e) {
//             responseEntity = ResponseEntity.badRequest().body(e.getMessage());
//         }
//         return responseEntity;
//     }

//     @GetMapping("/loanApplication/{id}")
//     public ResponseEntity<?> getLoanApplication(@PathVariable int id, Model model){
//         try {
//             LoanApplication loanApplication = loanApplicationService.getLoanApplication(id);
//             model.addAttribute("loanApplication", loanApplication);
//             model.addAttribute("file", Base64.getEncoder().encodeToString(loanApplication.getFile().getData()));
//             responseEntity = (ResponseEntity<?>) ResponseEntity.ok();
//         } catch (Exception e) {
//             responseEntity = ResponseEntity.badRequest().body(e.getMessage());
//         }
//         return responseEntity;
//     }

// }
