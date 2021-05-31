package lk.sanuka.mobilegaragesystem.adminservice.controller;

import lk.sanuka.mobilegaragesystem.adminservice.service.AdminService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.UnapprovedOperatorsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;


    @GetMapping(value = "/unapprovedOperators")
    public ResponseEntity<Set<Operator>> getUnapprovedOperators() {
        ResponseEntity<Set<Operator>> responseEntity;

        try{
            responseEntity = new ResponseEntity(adminService.getUnapprovedOperators(), HttpStatus.OK);
        } catch (UnapprovedOperatorsNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

}
