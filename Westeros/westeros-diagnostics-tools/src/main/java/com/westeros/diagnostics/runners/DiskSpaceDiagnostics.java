package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.services.contract.Diagnostics;

public class DiskSpaceDiagnostics implements IDiagnose {

     @Override
     public String getName() {
         return "Disk Space";
     }

     @Override
     public String getDescription() {
         return "Checks if there is free disk space";
     }

     @Override
     public Diagnostics run() {
         var file = new java.io.File(".");
         var freeSpace = file.getFreeSpace();
         if (freeSpace > 0) {
             return Diagnostics.Success(getName(), "Free space: " + freeSpace);
         }
         return Diagnostics.Failure(getName(), "No free space");
     }
 }
