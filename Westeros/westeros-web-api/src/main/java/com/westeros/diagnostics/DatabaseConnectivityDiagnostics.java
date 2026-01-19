package com.westeros.diagnostics;


import com.westeros.diagnostics.runners.IDiagnose;
import com.westeros.diagnostics.services.contract.Diagnostics;

@org.springframework.stereotype.Component
@lombok.RequiredArgsConstructor
public class DatabaseConnectivityDiagnostics implements IDiagnose {

     private final javax.sql.DataSource dataSource;

     @Override
     public String getName() {
         return "Database";
     }

     @Override
     public String getDescription() {
         return "Checks connection to the database";
     }

     @Override
     public Diagnostics run() {
         try (var connection = dataSource.getConnection()) {
             if (connection.isValid(2)) {
                 return Diagnostics.Success(getName(), "Database connection is valid");
             }
             return Diagnostics.Failure(getName(), "Database connection is invalid");
         } catch(java.sql.SQLException e) {
             return Diagnostics.Failure(getName(), "Database connection failed: " + e.getMessage());
         }
     }
}
