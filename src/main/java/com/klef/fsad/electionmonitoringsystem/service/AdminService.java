package com.klef.fsad.electionmonitoringsystem.service;

import com.klef.fsad.electionmonitoringsystem.entity.Admin;

//AdminService.java
public interface AdminService {
Admin verifyAdminLogin(String email, String password);
String registerAdmin(Admin admin);
}