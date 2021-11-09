package com.perennial.sme_payroll.controller;


import com.perennial.sme_payroll.entity.AuthRequest;
import com.perennial.sme_payroll.entity.AuthResponse;
import com.perennial.sme_payroll.entity.Employee;
import com.perennial.sme_payroll.exceptions.InvalidInputException;
import com.perennial.sme_payroll.helper.FileReader;
import com.perennial.sme_payroll.securityconfig.JwtUtil;
import com.perennial.sme_payroll.service.CRUDEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;


    @Autowired
    private FileReader fileReader;
    @Autowired
    private CRUDEmployee crudEmployee;


    @PostMapping("/employees")
    public void postEmployees(MultipartFile file) throws IOException, InvalidInputException {
        crudEmployee.post(fileReader.read(file));
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployees(@PathVariable("id")String id)
    {
        return crudEmployee.get(id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployees(@PathVariable("id")String id)
    {
         return crudEmployee.delete(id);
    }

    @PatchMapping("/employees/{id}")
    public String updateEmployees(@PathVariable("id")String id,@RequestBody Map<Object,Object> fields)
    {
        return crudEmployee.update(id,fields);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest) throws Exception
    {
           try{
               authenticationManager.authenticate(
                       new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
                       );
           }catch (BadCredentialsException e)
           {
               throw new Exception("Incorrect username and password",e);
           }

           final UserDetails userDetails=userDetailsService
                   .loadUserByUsername(authenticationRequest.getUsername());
           final String jwt=jwtTokenUtil.generateToken(userDetails);

           return ResponseEntity.ok(new AuthResponse(jwt));
    }
}

