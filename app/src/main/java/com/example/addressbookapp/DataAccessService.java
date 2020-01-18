package com.example.addressbookapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface DataAccessService {

    List<BaseContact> readAllContacts(String fileName) throws IOException;

    List<BaseContact> readAllContacts(InputStream inputStream) throws IOException;

    void saveAllContacts(String fileName, List<BaseContact> contacts, boolean append) throws IOException;


}
